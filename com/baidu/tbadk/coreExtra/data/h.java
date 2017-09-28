package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g aqE;
    private int mErrorCode;
    private String mErrorString;
    private boolean rg;

    public g xN() {
        return this.aqE;
    }

    public void b(g gVar) {
        this.aqE = gVar;
    }

    public boolean isSuccess() {
        return this.rg;
    }

    public void ay(boolean z) {
        this.rg = z;
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
