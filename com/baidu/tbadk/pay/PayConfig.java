package com.baidu.tbadk.pay;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PayConfig implements Serializable {
    private static final long serialVersionUID = 1473520404420820966L;
    private String mIsLeft;
    private boolean mIsPay;
    private String mMoney;
    private String mOrderName;
    private int mPayType;
    private String mPropsId;
    private String mPropsMon;
    private String mTitle;
    private int tBeanNum;

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mOrderName = str5;
    }

    public int getPayType() {
        return this.mPayType;
    }

    public void setPayType(int i) {
        this.mPayType = i;
    }

    public String getPropsId() {
        return this.mPropsId;
    }

    public void setPropsId(String str) {
        this.mPropsId = str;
    }

    public String getMoney() {
        return this.mMoney;
    }

    public void setMoney(String str) {
        this.mMoney = str;
    }

    public String getIsLeft() {
        return this.mIsLeft;
    }

    public void setIsLeft(String str) {
        this.mIsLeft = str;
    }

    public String getPropsMon() {
        return this.mPropsMon;
    }

    public void setPropsMon(String str) {
        this.mPropsMon = str;
    }

    public boolean isIsPay() {
        return this.mIsPay;
    }

    public void setIsPay(boolean z) {
        this.mIsPay = z;
    }

    public String getOrderName() {
        return this.mOrderName;
    }

    public void setOrderName(String str) {
        this.mOrderName = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public int getTBeanNum() {
        return this.tBeanNum;
    }

    public void setTBeanNum(int i) {
        this.tBeanNum = i;
    }
}
