package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class h {
    private String dCs;
    private String eWx;
    private boolean eWy;
    private long eWz = -1;
    private long eWA = -1;
    private long eWB = 0;
    private long eWC = 0;

    public String boe() {
        return this.eWx;
    }

    public void zN(String str) {
        this.eWx = str;
    }

    public String getOriginUrl() {
        return this.dCs;
    }

    public void zO(String str) {
        this.dCs = str;
    }

    public boolean bof() {
        return this.eWy;
    }

    public void jj(boolean z) {
        this.eWy = z;
    }

    public long bog() {
        return this.eWz;
    }

    public void cY(long j) {
        this.eWz = j;
    }

    public long boh() {
        return this.eWA;
    }

    public void cZ(long j) {
        this.eWA = j;
    }

    public long getTotalLength() {
        return this.eWB;
    }

    public void setTotalLength(long j) {
        this.eWB = j;
    }

    public void da(long j) {
        this.eWC = j;
    }

    public long boi() {
        return this.eWC;
    }
}
