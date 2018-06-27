package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i aBZ;
    private int mErrorCode;
    private String mErrorString;
    private boolean wn;

    public i Cp() {
        return this.aBZ;
    }

    public void b(i iVar) {
        this.aBZ = iVar;
    }

    public boolean isSuccess() {
        return this.wn;
    }

    public void aF(boolean z) {
        this.wn = z;
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
