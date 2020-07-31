package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long KQ = -1;
    public long KR = -1;
    public long KS = -1;
    private int eIO;
    private String eIP;
    private int errorCode;
    private String exception;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void Ag(String str) {
        this.eIP = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String blN() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.eIO + "-dnsStatus-" + this.eIP + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.KQ + "-fileLength-" + this.KR + "-contentLen-" + this.KS;
    }

    public void os(int i) {
        this.eIO = i;
    }
}
