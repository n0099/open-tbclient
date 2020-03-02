package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class h {
    private String cJQ;
    private String dWV;
    private boolean dWW;
    private long dWX = -1;
    private long dWY = -1;
    private long dWZ = 0;
    private long dXa = 0;

    public String aXi() {
        return this.dWV;
    }

    public void wx(String str) {
        this.dWV = str;
    }

    public String getOriginUrl() {
        return this.cJQ;
    }

    public void wy(String str) {
        this.cJQ = str;
    }

    public boolean aXj() {
        return this.dWW;
    }

    public void hB(boolean z) {
        this.dWW = z;
    }

    public long aXk() {
        return this.dWX;
    }

    public void cn(long j) {
        this.dWX = j;
    }

    public long aXl() {
        return this.dWY;
    }

    public void co(long j) {
        this.dWY = j;
    }

    public long getTotalLength() {
        return this.dWZ;
    }

    public void setTotalLength(long j) {
        this.dWZ = j;
    }

    public void cp(long j) {
        this.dXa = j;
    }

    public long aXm() {
        return this.dXa;
    }
}
