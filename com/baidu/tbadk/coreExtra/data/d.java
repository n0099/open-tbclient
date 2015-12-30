package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class d {
    private c aiM;
    private int mErrorCode;
    private String mErrorString;
    private boolean ru;

    public c wM() {
        return this.aiM;
    }

    public void b(c cVar) {
        this.aiM = cVar;
    }

    public boolean isSuccess() {
        return this.ru;
    }

    public void ap(boolean z) {
        this.ru = z;
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
