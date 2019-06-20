package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private k ceR;
    private int mErrorCode;
    private String mErrorString;
    private boolean wV;

    public k all() {
        return this.ceR;
    }

    public void b(k kVar) {
        this.ceR = kVar;
    }

    public boolean isSuccess() {
        return this.wV;
    }

    public void dU(boolean z) {
        this.wV = z;
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
