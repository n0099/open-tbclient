package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g aqs;
    private int mErrorCode;
    private String mErrorString;
    private boolean rh;

    public g xG() {
        return this.aqs;
    }

    public void b(g gVar) {
        this.aqs = gVar;
    }

    public boolean isSuccess() {
        return this.rh;
    }

    public void ax(boolean z) {
        this.rh = z;
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
