package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g aoI;
    private int mErrorCode;
    private String mErrorString;
    private boolean rM;

    public g xB() {
        return this.aoI;
    }

    public void b(g gVar) {
        this.aoI = gVar;
    }

    public boolean isSuccess() {
        return this.rM;
    }

    public void ay(boolean z) {
        this.rM = z;
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
