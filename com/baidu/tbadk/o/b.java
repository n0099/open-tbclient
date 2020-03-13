package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    private int dFs;
    private String dFt;
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

    public void vH(String str) {
        this.dFt = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String aRz() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.dFs + "-dnsStatus-" + this.dFt + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.qZ + "-fileLength-" + this.ra + "-contentLen-" + this.rb;
    }

    public void mO(int i) {
        this.dFs = i;
    }
}
