package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g arS;
    private int mErrorCode;
    private String mErrorString;
    private boolean tt;

    public g yl() {
        return this.arS;
    }

    public void b(g gVar) {
        this.arS = gVar;
    }

    public boolean isSuccess() {
        return this.tt;
    }

    public void ay(boolean z) {
        this.tt = z;
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
