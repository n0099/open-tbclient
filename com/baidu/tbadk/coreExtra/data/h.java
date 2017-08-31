package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g arz;
    private int mErrorCode;
    private String mErrorString;
    private boolean rf;

    public g yo() {
        return this.arz;
    }

    public void b(g gVar) {
        this.arz = gVar;
    }

    public boolean isSuccess() {
        return this.rf;
    }

    public void ay(boolean z) {
        this.rf = z;
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
