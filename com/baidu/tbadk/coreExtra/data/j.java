package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i aBQ;
    private int mErrorCode;
    private String mErrorString;
    private boolean wh;

    public i Ce() {
        return this.aBQ;
    }

    public void b(i iVar) {
        this.aBQ = iVar;
    }

    public boolean isSuccess() {
        return this.wh;
    }

    public void aE(boolean z) {
        this.wh = z;
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
