package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long NM = -1;
    public long NN = -1;
    public long NP = -1;
    private int errorCode;
    private String exception;
    private int fME;
    private String fMF;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void DD(String str) {
        this.fMF = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bEB() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.fME + "-dnsStatus-" + this.fMF + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.NM + "-fileLength-" + this.NN + "-contentLen-" + this.NP;
    }

    public void ry(int i) {
        this.fME = i;
    }
}
