package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class bo {
    private long bIF;
    private long bIG;
    private long bIH;
    private long bII;
    private long bIJ;

    public bo(Context context) {
        aQ(0L);
        aR(0L);
    }

    public void aQ(long j) {
        this.bIF = j;
    }

    public void aR(long j) {
        this.bIG = j;
    }

    public long Zb() {
        return this.bIG + this.bIF + this.bIH;
    }

    public void aS(long j) {
        this.bIH = j;
    }

    public void aT(long j) {
        this.bII = j;
    }

    public long Zc() {
        return this.bII;
    }

    public long Zd() {
        return this.bIJ;
    }

    public void aU(long j) {
        this.bIJ = j;
    }
}
