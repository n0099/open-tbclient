package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class d {
    private c ajz;
    private int mErrorCode;
    private String mErrorString;
    private boolean rB;

    public c xZ() {
        return this.ajz;
    }

    public void b(c cVar) {
        this.ajz = cVar;
    }

    public boolean isSuccess() {
        return this.rB;
    }

    public void aq(boolean z) {
        this.rB = z;
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
