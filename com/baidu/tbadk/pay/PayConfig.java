package com.baidu.tbadk.pay;

import com.baidu.tbadk.util.PageDialogHelper;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PayConfig implements Serializable {
    public static final int PAYTYPE_MEMBER = 1;
    public static final int PAYTYPE_PAY_DIRECT = 3;
    public static final int PAYTYPE_TDOU = 2;
    private static final long serialVersionUID = 1473520404420820966L;
    public long mCategoryId;
    private String mIsLeft;
    private boolean mIsPay;
    private boolean mIsPayDialog;
    private String mMoney;
    public boolean mNeedPayDetail;
    public String mOrderId;
    public String mOrderInfo;
    private String mOrderName;
    private PageDialogHelper.PayForm mPayForm;
    private int mPayType;
    private String mPropsId;
    private String mPropsMon;
    private String mTitle;
    public float mTotalPrice;
    private int tBeanNum;

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderId = "";
        this.mTotalPrice = 0.0f;
        this.mOrderInfo = "";
        this.mCategoryId = 0L;
        this.mNeedPayDetail = false;
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, boolean z2, PageDialogHelper.PayForm payForm) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderId = "";
        this.mTotalPrice = 0.0f;
        this.mOrderInfo = "";
        this.mCategoryId = 0L;
        this.mNeedPayDetail = false;
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        payForm = payForm == null ? PageDialogHelper.PayForm.NOT_SET : payForm;
        if (payForm == PageDialogHelper.PayForm.NOT_SET) {
            this.mIsPayDialog = z2;
        } else if (payForm == PageDialogHelper.PayForm.NORMAL) {
            this.mIsPayDialog = false;
        } else if (payForm == PageDialogHelper.PayForm.DIALOG) {
            this.mIsPayDialog = true;
        }
    }

    public boolean getIsPayDialog() {
        return this.mIsPayDialog;
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, PageDialogHelper.PayForm payForm) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderId = "";
        this.mTotalPrice = 0.0f;
        this.mOrderInfo = "";
        this.mCategoryId = 0L;
        this.mNeedPayDetail = false;
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mOrderName = str5;
        this.tBeanNum = Integer.parseInt(str5);
        payForm = payForm == null ? PageDialogHelper.PayForm.NOT_SET : payForm;
        if (payForm == PageDialogHelper.PayForm.NOT_SET) {
            this.mIsPayDialog = z2;
        } else if (payForm == PageDialogHelper.PayForm.NORMAL) {
            this.mIsPayDialog = false;
        } else if (payForm == PageDialogHelper.PayForm.DIALOG) {
            this.mIsPayDialog = true;
        }
    }

    public PayConfig(int i, String str, float f, boolean z, boolean z2) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderId = "";
        this.mTotalPrice = 0.0f;
        this.mOrderInfo = "";
        this.mCategoryId = 0L;
        this.mNeedPayDetail = false;
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.mPayType = i;
        this.mOrderId = str;
        this.mTotalPrice = f;
        this.mIsPay = z;
        this.mNeedPayDetail = z2;
    }

    public PayConfig(int i, long j, boolean z) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderId = "";
        this.mTotalPrice = 0.0f;
        this.mOrderInfo = "";
        this.mCategoryId = 0L;
        this.mNeedPayDetail = false;
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.mPayType = i;
        this.mCategoryId = j;
        this.mIsPay = z;
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
