package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long LD = -1;
    public long LG = -1;
    public long LH = -1;
    private int eWo;
    private String eWp;
    private int errorCode;
    private String exception;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void CT(String str) {
        this.eWp = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bvF() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.eWo + "-dnsStatus-" + this.eWp + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.LD + "-fileLength-" + this.LG + "-contentLen-" + this.LH;
    }

    public void qU(int i) {
        this.eWo = i;
    }
}
