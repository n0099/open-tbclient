package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g aoT;
    private int mErrorCode;
    private String mErrorString;
    private boolean rG;

    public g yu() {
        return this.aoT;
    }

    public void b(g gVar) {
        this.aoT = gVar;
    }

    public boolean isSuccess() {
        return this.rG;
    }

    public void aC(boolean z) {
        this.rG = z;
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
