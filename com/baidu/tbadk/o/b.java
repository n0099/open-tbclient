package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long Ka = -1;
    public long Kb = -1;
    public long Kc = -1;
    private int efp;
    private String efq;
    private int errorCode;
    private String exception;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void bF(String str) {
        this.exception = str;
    }

    public void wX(String str) {
        this.efq = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String aZN() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.efp + "-dnsStatus-" + this.efq + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.Ka + "-fileLength-" + this.Kb + "-contentLen-" + this.Kc;
    }

    public void nb(int i) {
        this.efp = i;
    }
}
