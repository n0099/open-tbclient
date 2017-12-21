package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i ars;
    private int mErrorCode;
    private String mErrorString;
    private boolean ri;

    public i xX() {
        return this.ars;
    }

    public void b(i iVar) {
        this.ars = iVar;
    }

    public boolean isSuccess() {
        return this.ri;
    }

    public void av(boolean z) {
        this.ri = z;
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
