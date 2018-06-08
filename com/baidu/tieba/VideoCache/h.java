package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class h {
    private String aai;
    private String bjw;
    private boolean bjx;
    private long bjy = -1;
    private long bjz = -1;
    private long bjA = 0;
    private long bjB = 0;

    public String PD() {
        return this.bjw;
    }

    public void ii(String str) {
        this.bjw = str;
    }

    public String PE() {
        return this.aai;
    }

    public void ij(String str) {
        this.aai = str;
    }

    public boolean PF() {
        return this.bjx;
    }

    public void cs(boolean z) {
        this.bjx = z;
    }

    public long PG() {
        return this.bjy;
    }

    public void az(long j) {
        this.bjy = j;
    }

    public long PH() {
        return this.bjz;
    }

    public void aA(long j) {
        this.bjz = j;
    }

    public long getTotalLength() {
        return this.bjA;
    }

    public void T(long j) {
        this.bjA = j;
    }

    public void aB(long j) {
        this.bjB = j;
    }

    public long PI() {
        return this.bjB;
    }
}
