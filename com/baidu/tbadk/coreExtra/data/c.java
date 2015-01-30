package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class c {
    private b QT;
    private boolean fS;
    private int mErrorCode;
    private String mErrorString;

    public b rI() {
        return this.QT;
    }

    public void b(b bVar) {
        this.QT = bVar;
    }

    public boolean isSuccess() {
        return this.fS;
    }

    public void au(boolean z) {
        this.fS = z;
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
