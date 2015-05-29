package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class c {
    private b abG;
    private int mErrorCode;
    private String mErrorString;
    private boolean rw;

    public b vi() {
        return this.abG;
    }

    public void b(b bVar) {
        this.abG = bVar;
    }

    public boolean isSuccess() {
        return this.rw;
    }

    public void al(boolean z) {
        this.rw = z;
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
