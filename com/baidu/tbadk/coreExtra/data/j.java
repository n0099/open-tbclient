package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private boolean afC;
    private i bhn;
    private int mErrorCode;
    private String mErrorString;

    public i FK() {
        return this.bhn;
    }

    public void b(i iVar) {
        this.bhn = iVar;
    }

    public boolean isSuccess() {
        return this.afC;
    }

    public void bh(boolean z) {
        this.afC = z;
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
