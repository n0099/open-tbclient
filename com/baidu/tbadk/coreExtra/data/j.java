package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i asY;
    private int mErrorCode;
    private String mErrorString;
    private boolean pZ;

    public i yx() {
        return this.asY;
    }

    public void b(i iVar) {
        this.asY = iVar;
    }

    public boolean isSuccess() {
        return this.pZ;
    }

    public void az(boolean z) {
        this.pZ = z;
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
