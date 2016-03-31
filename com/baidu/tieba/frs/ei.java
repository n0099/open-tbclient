package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class ei {
    private long bqv;
    private long bqw;
    private long bqx;
    private long bqy;
    private long bqz;

    public ei(Context context) {
        aB(0L);
        aC(0L);
    }

    public void aB(long j) {
        this.bqv = j;
    }

    public void aC(long j) {
        this.bqw = j;
    }

    public long Sq() {
        return this.bqw + this.bqv + this.bqx;
    }

    public void aD(long j) {
        this.bqx = j;
    }

    public void aE(long j) {
        this.bqy = j;
    }

    public long Sr() {
        return this.bqy;
    }

    public long Ss() {
        return this.bqz;
    }

    public void aF(long j) {
        this.bqz = j;
    }
}
