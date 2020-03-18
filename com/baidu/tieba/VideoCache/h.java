package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class h {
    private String cKc;
    private long dXA = -1;
    private long dXB = -1;
    private long dXC = 0;
    private long dXD = 0;
    private String dXy;
    private boolean dXz;

    public String aXn() {
        return this.dXy;
    }

    public void wy(String str) {
        this.dXy = str;
    }

    public String getOriginUrl() {
        return this.cKc;
    }

    public void wz(String str) {
        this.cKc = str;
    }

    public boolean aXo() {
        return this.dXz;
    }

    public void hC(boolean z) {
        this.dXz = z;
    }

    public long aXp() {
        return this.dXA;
    }

    public void cn(long j) {
        this.dXA = j;
    }

    public long aXq() {
        return this.dXB;
    }

    public void co(long j) {
        this.dXB = j;
    }

    public long getTotalLength() {
        return this.dXC;
    }

    public void setTotalLength(long j) {
        this.dXC = j;
    }

    public void cp(long j) {
        this.dXD = j;
    }

    public long aXr() {
        return this.dXD;
    }
}
