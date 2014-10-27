package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class c {
    private b Lf;
    private boolean dN;
    private int mErrorCode;
    private String mErrorString;

    public b ox() {
        return this.Lf;
    }

    public void b(b bVar) {
        this.Lf = bVar;
    }

    public boolean isSuccess() {
        return this.dN;
    }

    public void ab(boolean z) {
        this.dN = z;
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
