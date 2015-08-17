package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class c {
    private b agN;
    private int mErrorCode;
    private String mErrorString;
    private boolean rt;

    public b wq() {
        return this.agN;
    }

    public void b(b bVar) {
        this.agN = bVar;
    }

    public boolean isSuccess() {
        return this.rt;
    }

    public void ap(boolean z) {
        this.rt = z;
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
