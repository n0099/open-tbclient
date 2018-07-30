package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i aBT;
    private int mErrorCode;
    private String mErrorString;
    private boolean wg;

    public i Ch() {
        return this.aBT;
    }

    public void b(i iVar) {
        this.aBT = iVar;
    }

    public boolean isSuccess() {
        return this.wg;
    }

    public void aD(boolean z) {
        this.wg = z;
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
