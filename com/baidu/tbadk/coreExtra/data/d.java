package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class d {
    private c ahJ;
    private int mErrorCode;
    private String mErrorString;
    private boolean rt;

    public c xd() {
        return this.ahJ;
    }

    public void b(c cVar) {
        this.ahJ = cVar;
    }

    public boolean isSuccess() {
        return this.rt;
    }

    public void as(boolean z) {
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
