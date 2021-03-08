package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class q {
    private p fsm;
    private int mErrorCode;
    private String mErrorString;
    private boolean mIsSuccess;

    public p bwu() {
        return this.fsm;
    }

    public void b(p pVar) {
        this.fsm = pVar;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setIsSuccess(boolean z) {
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
