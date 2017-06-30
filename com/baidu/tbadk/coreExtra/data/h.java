package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g apJ;
    private int mErrorCode;
    private String mErrorString;
    private boolean rL;

    public g xS() {
        return this.apJ;
    }

    public void b(g gVar) {
        this.apJ = gVar;
    }

    public boolean isSuccess() {
        return this.rL;
    }

    public void az(boolean z) {
        this.rL = z;
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
