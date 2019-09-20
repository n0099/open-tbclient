package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private k cgW;
    private int mErrorCode;
    private String mErrorString;
    private boolean wY;

    public k amE() {
        return this.cgW;
    }

    public void b(k kVar) {
        this.cgW = kVar;
    }

    public boolean isSuccess() {
        return this.wY;
    }

    public void dY(boolean z) {
        this.wY = z;
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
