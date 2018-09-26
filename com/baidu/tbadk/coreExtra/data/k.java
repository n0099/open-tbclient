package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class k {
    private j aEW;
    private int mErrorCode;
    private String mErrorString;
    private boolean yA;

    public j Dr() {
        return this.aEW;
    }

    public void b(j jVar) {
        this.aEW = jVar;
    }

    public boolean isSuccess() {
        return this.yA;
    }

    public void aN(boolean z) {
        this.yA = z;
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
