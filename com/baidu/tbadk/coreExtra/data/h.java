package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g aoE;
    private int mErrorCode;
    private String mErrorString;
    private boolean sh;

    public g xW() {
        return this.aoE;
    }

    public void b(g gVar) {
        this.aoE = gVar;
    }

    public boolean isSuccess() {
        return this.sh;
    }

    public void aA(boolean z) {
        this.sh = z;
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
