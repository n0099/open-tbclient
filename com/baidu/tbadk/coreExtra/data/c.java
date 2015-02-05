package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class c {
    private b QP;
    private boolean fS;
    private int mErrorCode;
    private String mErrorString;

    public b rC() {
        return this.QP;
    }

    public void b(b bVar) {
        this.QP = bVar;
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
