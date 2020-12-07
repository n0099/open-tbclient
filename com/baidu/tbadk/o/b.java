package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long MU = -1;
    public long MV = -1;
    public long MW = -1;
    private int errorCode;
    private String exception;
    private int fDV;
    private String fDW;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void Ew(String str) {
        this.fDW = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bFB() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.fDV + "-dnsStatus-" + this.fDW + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.MU + "-fileLength-" + this.MV + "-contentLen-" + this.MW;
    }

    public void sM(int i) {
        this.fDV = i;
    }
}
