package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i asX;
    private int mErrorCode;
    private String mErrorString;
    private boolean qa;

    public i yy() {
        return this.asX;
    }

    public void b(i iVar) {
        this.asX = iVar;
    }

    public boolean isSuccess() {
        return this.qa;
    }

    public void az(boolean z) {
        this.qa = z;
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
