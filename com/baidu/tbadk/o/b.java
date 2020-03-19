package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    private int dFI;
    private String dFJ;
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

    public void vI(String str) {
        this.dFJ = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String aRD() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.dFI + "-dnsStatus-" + this.dFJ + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.qZ + "-fileLength-" + this.ra + "-contentLen-" + this.rb;
    }

    public void mQ(int i) {
        this.dFI = i;
    }
}
