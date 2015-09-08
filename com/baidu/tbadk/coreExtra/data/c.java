package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class c {
    private b agX;
    private int mErrorCode;
    private String mErrorString;
    private boolean rr;

    public b ww() {
        return this.agX;
    }

    public void b(b bVar) {
        this.agX = bVar;
    }

    public boolean isSuccess() {
        return this.rr;
    }

    public void ap(boolean z) {
        this.rr = z;
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
