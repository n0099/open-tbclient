package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long Kp = -1;
    public long Kq = -1;
    public long Kr = -1;
    private int errorCode;
    private int etI;
    private String etJ;
    private String exception;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void yG(String str) {
        this.etJ = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bfV() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.etI + "-dnsStatus-" + this.etJ + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.Kp + "-fileLength-" + this.Kq + "-contentLen-" + this.Kr;
    }

    public void nD(int i) {
        this.etI = i;
    }
}
