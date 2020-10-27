package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long LZ = -1;
    public long Ma = -1;
    public long Mb = -1;
    private int errorCode;
    private String exception;
    private int fqX;
    private String fqY;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void DY(String str) {
        this.fqY = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bAi() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.fqX + "-dnsStatus-" + this.fqY + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.LZ + "-fileLength-" + this.Ma + "-contentLen-" + this.Mb;
    }

    public void rD(int i) {
        this.fqX = i;
    }
}
