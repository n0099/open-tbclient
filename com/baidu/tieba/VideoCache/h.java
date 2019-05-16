package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class h {
    private String bzP;
    private String cTS;
    private boolean cTT;
    private long cTU = -1;
    private long cTV = -1;
    private long cTW = 0;
    private long cTX = 0;

    public String aAN() {
        return this.cTS;
    }

    public void rE(String str) {
        this.cTS = str;
    }

    public String aAO() {
        return this.bzP;
    }

    public void rF(String str) {
        this.bzP = str;
    }

    public boolean aAP() {
        return this.cTT;
    }

    public void gf(boolean z) {
        this.cTT = z;
    }

    public long aAQ() {
        return this.cTU;
    }

    public void bK(long j) {
        this.cTU = j;
    }

    public long aAR() {
        return this.cTV;
    }

    public void bL(long j) {
        this.cTV = j;
    }

    public long getTotalLength() {
        return this.cTW;
    }

    public void bd(long j) {
        this.cTW = j;
    }

    public void bM(long j) {
        this.cTX = j;
    }

    public long aAS() {
        return this.cTX;
    }
}
