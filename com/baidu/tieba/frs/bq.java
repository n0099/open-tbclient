package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class bq {
    private long bRU;
    private long bRV;
    private long bRW;
    private long bRX;
    private long bRY;

    public bq(Context context) {
        aQ(0L);
        aR(0L);
    }

    public void aQ(long j) {
        this.bRU = j;
    }

    public void aR(long j) {
        this.bRV = j;
    }

    public long abz() {
        return this.bRV + this.bRU + this.bRW;
    }

    public void aS(long j) {
        this.bRW = j;
    }

    public void aT(long j) {
        this.bRX = j;
    }

    public long abA() {
        return this.bRX;
    }

    public long abB() {
        return this.bRY;
    }

    public void aU(long j) {
        this.bRY = j;
    }
}
