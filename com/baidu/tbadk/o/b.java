package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long LY = -1;
    public long LZ = -1;
    public long Ma = -1;
    private int errorCode;
    private String exception;
    private int fiA;
    private String fiB;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void DF(String str) {
        this.fiB = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String byp() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.fiA + "-dnsStatus-" + this.fiB + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.LY + "-fileLength-" + this.LZ + "-contentLen-" + this.Ma;
    }

    public void rs(int i) {
        this.fiA = i;
    }
}
