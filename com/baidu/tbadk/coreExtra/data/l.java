package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private k bWV;
    private int mErrorCode;
    private String mErrorString;
    private boolean zk;

    public k agm() {
        return this.bWV;
    }

    public void b(k kVar) {
        this.bWV = kVar;
    }

    public boolean isSuccess() {
        return this.zk;
    }

    public void dy(boolean z) {
        this.zk = z;
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
