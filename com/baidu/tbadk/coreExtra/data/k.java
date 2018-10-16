package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class k {
    private j aJz;
    private int mErrorCode;
    private String mErrorString;
    private boolean mIsSuccess;

    public j Fs() {
        return this.aJz;
    }

    public void b(j jVar) {
        this.aJz = jVar;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void aX(boolean z) {
        this.mIsSuccess = z;
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
