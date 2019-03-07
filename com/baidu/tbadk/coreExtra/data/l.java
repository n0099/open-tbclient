package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private k bWR;
    private int mErrorCode;
    private String mErrorString;
    private boolean zl;

    public k agp() {
        return this.bWR;
    }

    public void b(k kVar) {
        this.bWR = kVar;
    }

    public boolean isSuccess() {
        return this.zl;
    }

    public void dy(boolean z) {
        this.zl = z;
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
