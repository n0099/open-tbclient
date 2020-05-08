package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long Ke = -1;
    public long Kf = -1;
    public long Kg = -1;
    private int efu;
    private String efv;
    private int errorCode;
    private String exception;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void bF(String str) {
        this.exception = str;
    }

    public void xa(String str) {
        this.efv = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String aZL() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.efu + "-dnsStatus-" + this.efv + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.Ke + "-fileLength-" + this.Kf + "-contentLen-" + this.Kg;
    }

    public void nb(int i) {
        this.efu = i;
    }
}
