package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private boolean afK;
    private i bfG;
    private int mErrorCode;
    private String mErrorString;

    public i Fp() {
        return this.bfG;
    }

    public void b(i iVar) {
        this.bfG = iVar;
    }

    public boolean isSuccess() {
        return this.afK;
    }

    public void be(boolean z) {
        this.afK = z;
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
