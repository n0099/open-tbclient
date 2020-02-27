package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class h {
    private String cJP;
    private String dWU;
    private boolean dWV;
    private long dWW = -1;
    private long dWX = -1;
    private long dWY = 0;
    private long dWZ = 0;

    public String aXg() {
        return this.dWU;
    }

    public void wx(String str) {
        this.dWU = str;
    }

    public String getOriginUrl() {
        return this.cJP;
    }

    public void wy(String str) {
        this.cJP = str;
    }

    public boolean aXh() {
        return this.dWV;
    }

    public void hB(boolean z) {
        this.dWV = z;
    }

    public long aXi() {
        return this.dWW;
    }

    public void cn(long j) {
        this.dWW = j;
    }

    public long aXj() {
        return this.dWX;
    }

    public void co(long j) {
        this.dWX = j;
    }

    public long getTotalLength() {
        return this.dWY;
    }

    public void setTotalLength(long j) {
        this.dWY = j;
    }

    public void cp(long j) {
        this.dWZ = j;
    }

    public long aXk() {
        return this.dWZ;
    }
}
