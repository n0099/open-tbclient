package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long Mp = -1;
    public long Mq = -1;
    public long Mr = -1;
    private int errorCode;
    private String exception;
    private int fIT;
    private String fIU;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void Dh(String str) {
        this.fIU = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bEf() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.fIT + "-dnsStatus-" + this.fIU + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.Mp + "-fileLength-" + this.Mq + "-contentLen-" + this.Mr;
    }

    public void rr(int i) {
        this.fIT = i;
    }
}
