package com.baidu.tbadk.o;
/* loaded from: classes2.dex */
public class b {
    public long Lt = -1;
    public long Lu = -1;
    public long Lv = -1;
    private int eTu;
    private String eTv;
    private int errorCode;
    private String exception;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void Cw(String str) {
        this.eTv = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String buA() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.eTu + "-dnsStatus-" + this.eTv + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.Lt + "-fileLength-" + this.Lu + "-contentLen-" + this.Lv;
    }

    public void qD(int i) {
        this.eTu = i;
    }
}
