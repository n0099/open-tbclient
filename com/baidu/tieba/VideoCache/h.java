package com.baidu.tieba.VideoCache;
/* loaded from: classes6.dex */
public class h {
    private String cFz;
    private String dSG;
    private boolean dSH;
    private long dSI = -1;
    private long dSJ = -1;
    private long dSK = 0;
    private long dSL = 0;

    public String aUw() {
        return this.dSG;
    }

    public void vZ(String str) {
        this.dSG = str;
    }

    public String getOriginUrl() {
        return this.cFz;
    }

    public void wa(String str) {
        this.cFz = str;
    }

    public boolean aUx() {
        return this.dSH;
    }

    public void hp(boolean z) {
        this.dSH = z;
    }

    public long aUy() {
        return this.dSI;
    }

    public void ce(long j) {
        this.dSI = j;
    }

    public long aUz() {
        return this.dSJ;
    }

    public void cf(long j) {
        this.dSJ = j;
    }

    public long getTotalLength() {
        return this.dSK;
    }

    public void setTotalLength(long j) {
        this.dSK = j;
    }

    public void cg(long j) {
        this.dSL = j;
    }

    public long aUA() {
        return this.dSL;
    }
}
