package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class h {
    private String bzP;
    private String cTU;
    private boolean cTV;
    private long cTW = -1;
    private long cTX = -1;
    private long cTY = 0;
    private long cTZ = 0;

    public String aAQ() {
        return this.cTU;
    }

    public void rD(String str) {
        this.cTU = str;
    }

    public String aAR() {
        return this.bzP;
    }

    public void rE(String str) {
        this.bzP = str;
    }

    public boolean aAS() {
        return this.cTV;
    }

    public void gf(boolean z) {
        this.cTV = z;
    }

    public long aAT() {
        return this.cTW;
    }

    public void bK(long j) {
        this.cTW = j;
    }

    public long aAU() {
        return this.cTX;
    }

    public void bL(long j) {
        this.cTX = j;
    }

    public long getTotalLength() {
        return this.cTY;
    }

    public void bd(long j) {
        this.cTY = j;
    }

    public void bM(long j) {
        this.cTZ = j;
    }

    public long aAV() {
        return this.cTZ;
    }
}
