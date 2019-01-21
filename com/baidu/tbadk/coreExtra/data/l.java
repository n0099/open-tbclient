package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private k aOt;
    private int mErrorCode;
    private String mErrorString;
    private boolean mIsSuccess;

    public k GW() {
        return this.aOt;
    }

    public void b(k kVar) {
        this.aOt = kVar;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void bp(boolean z) {
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
