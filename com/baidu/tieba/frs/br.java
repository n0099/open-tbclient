package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class br {
    private long bVd;
    private long bVe;
    private long bVf;
    private long bVg;
    private long bVh;

    public br(Context context) {
        bh(0L);
        bi(0L);
    }

    public void bh(long j) {
        this.bVd = j;
    }

    public void bi(long j) {
        this.bVe = j;
    }

    public long adB() {
        return this.bVe + this.bVd + this.bVf;
    }

    public void bj(long j) {
        this.bVf = j;
    }

    public void bk(long j) {
        this.bVg = j;
    }

    public long adC() {
        return this.bVg;
    }

    public long adD() {
        return this.bVh;
    }

    public void bl(long j) {
        this.bVh = j;
    }
}
