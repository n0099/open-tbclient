package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class d {
    private c ajP;
    private int mErrorCode;
    private String mErrorString;
    private boolean rL;

    public c yA() {
        return this.ajP;
    }

    public void b(c cVar) {
        this.ajP = cVar;
    }

    public boolean isSuccess() {
        return this.rL;
    }

    public void as(boolean z) {
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
