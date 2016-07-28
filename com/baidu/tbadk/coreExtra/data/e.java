package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class e {
    private d agT;
    private boolean hZ;
    private int mErrorCode;
    private String mErrorString;

    public d wx() {
        return this.agT;
    }

    public void b(d dVar) {
        this.agT = dVar;
    }

    public boolean isSuccess() {
        return this.hZ;
    }

    public void aw(boolean z) {
        this.hZ = z;
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
