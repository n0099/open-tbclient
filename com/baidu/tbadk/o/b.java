package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class b {
    public long KQ = -1;
    public long KR = -1;
    public long KS = -1;
    private String eCA;
    private int eCz;
    private int errorCode;
    private String exception;
    private String url;

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void yZ(String str) {
        this.eCA = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String bic() {
        return "-netErrorCode-" + this.errorCode + "-serverCode-" + this.eCz + "-dnsStatus-" + this.eCA + "-exception-" + this.exception + "-url-" + this.url + "-dataLenth-" + this.KQ + "-fileLength-" + this.KR + "-contentLen-" + this.KS;
    }

    public void oa(int i) {
        this.eCz = i;
    }
}
