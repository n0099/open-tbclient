package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private k cuT;
    private int mErrorCode;
    private String mErrorString;
    private boolean mIsSuccess;

    public k aph() {
        return this.cuT;
    }

    public void b(k kVar) {
        this.cuT = kVar;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setIsSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }
}
