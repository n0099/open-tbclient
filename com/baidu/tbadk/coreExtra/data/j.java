package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private boolean afI;
    private i bfs;
    private int mErrorCode;
    private String mErrorString;

    public i Fw() {
        return this.bfs;
    }

    public void b(i iVar) {
        this.bfs = iVar;
    }

    public boolean isSuccess() {
        return this.afI;
    }

    public void bd(boolean z) {
        this.afI = z;
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
