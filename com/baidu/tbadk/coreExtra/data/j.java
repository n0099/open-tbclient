package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i aBf;
    private int mErrorCode;
    private String mErrorString;
    private boolean wp;

    public i BX() {
        return this.aBf;
    }

    public void b(i iVar) {
        this.aBf = iVar;
    }

    public boolean isSuccess() {
        return this.wp;
    }

    public void aD(boolean z) {
        this.wp = z;
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
