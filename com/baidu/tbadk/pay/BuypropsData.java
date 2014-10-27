package com.baidu.tbadk.pay;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BuypropsData extends i implements Serializable {
    private static final long serialVersionUID = 2238764304780158007L;
    private String errmsg;
    private int errno;
    private PayInfo pay_info;
    private String usermsg;

    /* loaded from: classes.dex */
    public class PayInfo extends i implements Serializable {
        private static final long serialVersionUID = -8302988741059705808L;
        private int amount;
        private String bduss;
        private String charset;
        private String clientIp;
        private int currency;
        private String device;
        private String goodsName;
        private String orderId;
        private int productAmount;
        private String productNo;
        private String returnUrl;
        private String securityTimeStamp;
        private String sign;
        private int signMethod;
        private String version;

        public String getProductNo() {
            return this.productNo;
        }

        public void setProductNo(String str) {
            this.productNo = str;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public String getSecurityTimeStamp() {
            return this.securityTimeStamp;
        }

        public void setSecurityTimeStamp(String str) {
            this.securityTimeStamp = str;
        }

        public String getReturnUrl() {
            return this.returnUrl;
        }

        public void setReturnUrl(String str) {
            this.returnUrl = str;
        }

        public String getGoodsName() {
            return this.goodsName;
        }

        public void setGoodsName(String str) {
            this.goodsName = str;
        }

        public int getAmount() {
            return this.amount;
        }

        public void setAmount(int i) {
            this.amount = i;
        }

        public int getProductAmount() {
            return this.productAmount;
        }

        public void setProductAmount(int i) {
            this.productAmount = i;
        }

        public int getSignMethod() {
            return this.signMethod;
        }

        public void setSignMethod(int i) {
            this.signMethod = i;
        }

        public String getClientIp() {
            return this.clientIp;
        }

        public void setClientIp(String str) {
            this.clientIp = str;
        }

        public String getCharset() {
            return this.charset;
        }

        public void setCharset(String str) {
            this.charset = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String getDevice() {
            return this.device;
        }

        public void setDevice(String str) {
            this.device = str;
        }

        public String getBduss() {
            return this.bduss;
        }

        public void setBduss(String str) {
            this.bduss = str;
        }

        public String getSign() {
            return this.sign;
        }

        public void setSign(String str) {
            this.sign = str;
        }

        public int getCurrency() {
            return this.currency;
        }

        public void setCurrency(int i) {
            this.currency = i;
        }
    }

    public int getErrno() {
        return this.errno;
    }

    public void setErrno(int i) {
        this.errno = i;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public String getUsermsg() {
        return this.usermsg;
    }

    public void setUsermsg(String str) {
        this.usermsg = str;
    }

    public PayInfo getPay_info() {
        return this.pay_info;
    }

    public void setPay_info(PayInfo payInfo) {
        this.pay_info = payInfo;
    }
}
