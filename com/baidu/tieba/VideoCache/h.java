package com.baidu.tieba.VideoCache;
/* loaded from: classes7.dex */
public class h {
    private String cFL;
    private String dSP;
    private boolean dSQ;
    private long dSR = -1;
    private long dSS = -1;
    private long dST = 0;
    private long dSU = 0;

    public String aUQ() {
        return this.dSP;
    }

    public void wd(String str) {
        this.dSP = str;
    }

    public String getOriginUrl() {
        return this.cFL;
    }

    public void we(String str) {
        this.cFL = str;
    }

    public boolean aUR() {
        return this.dSQ;
    }

    public void hu(boolean z) {
        this.dSQ = z;
    }

    public long aUS() {
        return this.dSR;
    }

    public void cj(long j) {
        this.dSR = j;
    }

    public long aUT() {
        return this.dSS;
    }

    public void ck(long j) {
        this.dSS = j;
    }

    public long getTotalLength() {
        return this.dST;
    }

    public void setTotalLength(long j) {
        this.dST = j;
    }

    public void cl(long j) {
        this.dSU = j;
    }

    public long aUU() {
        return this.dSU;
    }
}
