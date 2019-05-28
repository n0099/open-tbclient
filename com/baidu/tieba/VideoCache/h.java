package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class h {
    private String bzP;
    private String cTT;
    private boolean cTU;
    private long cTV = -1;
    private long cTW = -1;
    private long cTX = 0;
    private long cTY = 0;

    public String aAQ() {
        return this.cTT;
    }

    public void rE(String str) {
        this.cTT = str;
    }

    public String aAR() {
        return this.bzP;
    }

    public void rF(String str) {
        this.bzP = str;
    }

    public boolean aAS() {
        return this.cTU;
    }

    public void gf(boolean z) {
        this.cTU = z;
    }

    public long aAT() {
        return this.cTV;
    }

    public void bK(long j) {
        this.cTV = j;
    }

    public long aAU() {
        return this.cTW;
    }

    public void bL(long j) {
        this.cTW = j;
    }

    public long getTotalLength() {
        return this.cTX;
    }

    public void bd(long j) {
        this.cTX = j;
    }

    public void bM(long j) {
        this.cTY = j;
    }

    public long aAV() {
        return this.cTY;
    }
}
