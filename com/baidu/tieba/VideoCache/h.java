package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class h {
    private String cJR;
    private String dXi;
    private boolean dXj;
    private long dXk = -1;
    private long dXl = -1;
    private long dXm = 0;
    private long dXn = 0;

    public String aXj() {
        return this.dXi;
    }

    public void wy(String str) {
        this.dXi = str;
    }

    public String getOriginUrl() {
        return this.cJR;
    }

    public void wz(String str) {
        this.cJR = str;
    }

    public boolean aXk() {
        return this.dXj;
    }

    public void hB(boolean z) {
        this.dXj = z;
    }

    public long aXl() {
        return this.dXk;
    }

    public void cn(long j) {
        this.dXk = j;
    }

    public long aXm() {
        return this.dXl;
    }

    public void co(long j) {
        this.dXl = j;
    }

    public long getTotalLength() {
        return this.dXm;
    }

    public void setTotalLength(long j) {
        this.dXm = j;
    }

    public void cp(long j) {
        this.dXn = j;
    }

    public long aXn() {
        return this.dXn;
    }
}
