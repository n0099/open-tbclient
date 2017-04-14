package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class bq {
    private long bPD;
    private long bPE;
    private long bPF;
    private long bPG;
    private long bPH;

    public bq(Context context) {
        aQ(0L);
        aR(0L);
    }

    public void aQ(long j) {
        this.bPD = j;
    }

    public void aR(long j) {
        this.bPE = j;
    }

    public long aay() {
        return this.bPE + this.bPD + this.bPF;
    }

    public void aS(long j) {
        this.bPF = j;
    }

    public void aT(long j) {
        this.bPG = j;
    }

    public long aaz() {
        return this.bPG;
    }

    public long aaA() {
        return this.bPH;
    }

    public void aU(long j) {
        this.bPH = j;
    }
}
