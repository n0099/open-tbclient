package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long Mr = -1;
    public long Ms = -1;
    public long Mt = -1;
    private int errorCode;
    private String exception;
    private int fNA;
    private String fNB;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void Et(String str) {
        this.fNB = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bHW() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.fNA + "-dnsStatus-" + this.fNB + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.Mr + "-fileLength-" + this.Ms + "-contentLen-" + this.Mt;
    }

    public void sX(int i) {
        this.fNA = i;
    }
}
