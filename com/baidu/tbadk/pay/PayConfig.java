package com.baidu.tbadk.pay;

import com.baidu.tbadk.util.PageDialogHelper;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class PayConfig implements Serializable {
    public static final String PAYMENT_POS_KEY_DUIBA = "1634";
    public static final String PAYMENT_POS_KEY_MANGA = "37";
    public static final int PAYTYPE_MEMBER = 1;
    public static final int PAYTYPE_PAY_DIRECT = 3;
    public static final int PAYTYPE_TDOU = 2;
    public static final int PAYTYPE_TYPE_CARDBOX = 4;
    public static final long serialVersionUID = 1473520404420820966L;
    public int isAutoPay;
    public int isFromDecreaseGiftStepStrategy;
    public String mClickZone;
    public int mFrom;
    public String mIsLeft;
    public boolean mIsPay;
    public boolean mIsPayDialog;
    public String mMoney;
    public String mOrderInfo;
    public String mOrderName;
    public PageDialogHelper.PayForm mPayForm;
    public int mPayType;
    public String mPropsId;
    public String mPropsMon;
    public String mReferPage;
    public String mTitle;
    public long orderCompleteTime;
    public String paymentPosKey;
    public int tBeanNum;

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mReferPage = str5;
        this.mClickZone = str6;
    }

    public int getFrom() {
        return this.mFrom;
    }

    public String getIsLeft() {
        return this.mIsLeft;
    }

    public boolean getIsPayDialog() {
        return this.mIsPayDialog;
    }

    public String getMoney() {
        return this.mMoney;
    }

    public String getOrderName() {
        return this.mOrderName;
    }

    public int getPayType() {
        return this.mPayType;
    }

    public String getPropsId() {
        return this.mPropsId;
    }

    public String getPropsMon() {
        return this.mPropsMon;
    }

    public int getTBeanNum() {
        return this.tBeanNum;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int isAutoPay() {
        return this.isAutoPay;
    }

    public int isFromDecreaseGiftStepStrategy() {
        return this.isFromDecreaseGiftStepStrategy;
    }

    public boolean isIsPay() {
        return this.mIsPay;
    }

    public void setAutoPay(int i) {
        this.isAutoPay = i;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFromDecreaseGiftStepStrategy(int i) {
        this.isFromDecreaseGiftStepStrategy = i;
    }

    public void setIsLeft(String str) {
        this.mIsLeft = str;
    }

    public void setIsPay(boolean z) {
        this.mIsPay = z;
    }

    public void setMoney(String str) {
        this.mMoney = str;
    }

    public void setOrderName(String str) {
        this.mOrderName = str;
    }

    public void setPayType(int i) {
        this.mPayType = i;
    }

    public void setPropsId(String str) {
        this.mPropsId = str;
    }

    public void setPropsMon(String str) {
        this.mPropsMon = str;
    }

    public void setTBeanNum(int i) {
        this.tBeanNum = i;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, boolean z2, PageDialogHelper.PayForm payForm, String str5, String str6) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        PageDialogHelper.PayForm payForm2 = PageDialogHelper.PayForm.NOT_SET;
        this.mPayForm = payForm2;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mReferPage = str5;
        this.mClickZone = str6;
        payForm = payForm == null ? payForm2 : payForm;
        if (payForm == PageDialogHelper.PayForm.NOT_SET) {
            this.mIsPayDialog = z2;
        } else if (payForm == PageDialogHelper.PayForm.NORMAL) {
            this.mIsPayDialog = false;
        } else if (payForm == PageDialogHelper.PayForm.DIALOG) {
            this.mIsPayDialog = true;
        }
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, PageDialogHelper.PayForm payForm, String str6, String str7) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mOrderName = str5;
        this.mReferPage = str6;
        this.mClickZone = str7;
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
}
