package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cx {
    private long bGC;
    private long bGD;
    private long bGE;
    private long bGF;
    private long bGG;

    public cx(Context context) {
        aR(0L);
        aS(0L);
    }

    public void aR(long j) {
        this.bGC = j;
    }

    public void aS(long j) {
        this.bGD = j;
    }

    public long WT() {
        return this.bGD + this.bGC + this.bGE;
    }

    public void aT(long j) {
        this.bGE = j;
    }

    public void aU(long j) {
        this.bGF = j;
    }

    public long WU() {
        return this.bGF;
    }

    public long WV() {
        return this.bGG;
    }

    public void aV(long j) {
        this.bGG = j;
    }
}
