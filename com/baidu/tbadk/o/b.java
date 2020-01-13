package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    private int dBd;
    private String dBe;
    private int errorCode;
    private String exception;
    public long qY = -1;
    public long qZ = -1;
    public long ra = -1;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void aq(String str) {
        this.exception = str;
    }

    public void vm(String str) {
        this.dBe = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String aPg() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.dBd + "-dnsStatus-" + this.dBe + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.qY + "-fileLength-" + this.qZ + "-contentLen-" + this.ra;
    }

    public void mx(int i) {
        this.dBd = i;
    }
}
