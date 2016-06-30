package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class e {
    private d agf;
    private boolean hx;
    private int mErrorCode;
    private String mErrorString;

    public d wx() {
        return this.agf;
    }

    public void b(d dVar) {
        this.agf = dVar;
    }

    public boolean isSuccess() {
        return this.hx;
    }

    public void at(boolean z) {
        this.hx = z;
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
