package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class i {
    private String PU;
    private String aSJ;
    private boolean aSK;
    private long aSL = -1;
    private long aSM = -1;
    private long aSN = 0;

    public String JN() {
        return this.aSJ;
    }

    public void gI(String str) {
        this.aSJ = str;
    }

    public String JO() {
        return this.PU;
    }

    public void gJ(String str) {
        this.PU = str;
    }

    public boolean JP() {
        return this.aSK;
    }

    public void cl(boolean z) {
        this.aSK = z;
    }

    public long JQ() {
        return this.aSL;
    }

    public void aq(long j) {
        this.aSL = j;
    }

    public long JR() {
        return this.aSM;
    }

    public void ar(long j) {
        this.aSM = j;
    }

    public long getTotalLength() {
        return this.aSN;
    }

    public void M(long j) {
        this.aSN = j;
    }
}
