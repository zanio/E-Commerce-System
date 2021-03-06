package edu.mum.estore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	private String productName;
	private double productPrice;
	private long productQuantity;
	private long maxPerCustomer;
	private long lockNumber;
	@Column(name = "approve", nullable = false, columnDefinition = "bit default 0")
	private boolean approve;
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	@Column(length=3000)
	private String description;
	private String image_link;
	
	@Transient
	private long purchaseQty=0;
	
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getMaxPerCustomer() {
		return maxPerCustomer;
	}
	public void setMaxPerCustomer(long maxPerCustomer) {
		this.maxPerCustomer = maxPerCustomer;
	}
	public long getLockNumber() {
		return lockNumber;
	}
	public void setLockNumber(long lockNumber) {
		this.lockNumber = lockNumber;
	}
	@JsonIgnore
	@Transient
	private MultipartFile productImage;
	
	@ManyToOne
	private Vendor vendor;
	
	
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	@OneToOne
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public String printAsString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", maxPerCustomer=" + maxPerCustomer + ", lockNumber="
				+ lockNumber + ", approve=" + approve + ", description=" + description + ", image_link=" + image_link
				+ ", productImage=" + productImage + ", vendor=" + vendor + ", category=" + category + "]";
	}
	
	

}
