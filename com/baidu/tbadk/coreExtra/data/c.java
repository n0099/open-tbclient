package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class c {
    private b aaC;
    private int mErrorCode;
    private String mErrorString;
    private boolean rl;

    public b uz() {
        return this.aaC;
    }

    public void b(b bVar) {
        this.aaC = bVar;
    }

    public boolean isSuccess() {
        return this.rl;
    }

    public void af(boolean z) {
        this.rl = z;
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
