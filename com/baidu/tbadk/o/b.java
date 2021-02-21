package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long Mn = -1;
    public long Mo = -1;
    public long Mp = -1;
    private int errorCode;
    private String exception;
    private int fLe;
    private String fLf;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void Dw(String str) {
        this.fLf = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bEx() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.fLe + "-dnsStatus-" + this.fLf + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.Mn + "-fileLength-" + this.Mo + "-contentLen-" + this.Mp;
    }

    public void rw(int i) {
        this.fLe = i;
    }
}
