package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private g arT;
    private int mErrorCode;
    private String mErrorString;

    /* renamed from: tv  reason: collision with root package name */
    private boolean f2tv;

    public g yl() {
        return this.arT;
    }

    public void b(g gVar) {
        this.arT = gVar;
    }

    public boolean isSuccess() {
        return this.f2tv;
    }

    public void ay(boolean z) {
        this.f2tv = z;
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
