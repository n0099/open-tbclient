package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    private int dAT;
    private String dAU;
    private int errorCode;
    private String exception;
    public long qZ = -1;
    public long ra = -1;
    public long rb = -1;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void aq(String str) {
        this.exception = str;
    }

    public void vh(String str) {
        this.dAU = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String aON() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.dAT + "-dnsStatus-" + this.dAU + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.qZ + "-fileLength-" + this.ra + "-contentLen-" + this.rb;
    }

    public void mx(int i) {
        this.dAT = i;
    }
}
