package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class bq {
    private long bBl;
    private long bBm;
    private long bBn;
    private long bBo;
    private long bBp;

    public bq(Context context) {
        aU(0L);
        aV(0L);
    }

    public void aU(long j) {
        this.bBl = j;
    }

    public void aV(long j) {
        this.bBm = j;
    }

    public long XU() {
        return this.bBm + this.bBl + this.bBn;
    }

    public void aW(long j) {
        this.bBn = j;
    }

    public void aX(long j) {
        this.bBo = j;
    }

    public long XV() {
        return this.bBo;
    }

    public long XW() {
        return this.bBp;
    }

    public void aY(long j) {
        this.bBp = j;
    }
}
