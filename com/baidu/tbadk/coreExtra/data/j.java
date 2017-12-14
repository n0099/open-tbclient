package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private i arp;
    private int mErrorCode;
    private String mErrorString;
    private boolean rh;

    public i xX() {
        return this.arp;
    }

    public void b(i iVar) {
        this.arp = iVar;
    }

    public boolean isSuccess() {
        return this.rh;
    }

    public void av(boolean z) {
        this.rh = z;
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
