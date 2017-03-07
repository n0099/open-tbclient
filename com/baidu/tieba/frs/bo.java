package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class bo {
    private long bPO;
    private long bPP;
    private long bPQ;
    private long bPR;
    private long bPS;

    public bo(Context context) {
        aQ(0L);
        aR(0L);
    }

    public void aQ(long j) {
        this.bPO = j;
    }

    public void aR(long j) {
        this.bPP = j;
    }

    public long aaa() {
        return this.bPP + this.bPO + this.bPQ;
    }

    public void aS(long j) {
        this.bPQ = j;
    }

    public void aT(long j) {
        this.bPR = j;
    }

    public long aab() {
        return this.bPR;
    }

    public long aac() {
        return this.bPS;
    }

    public void aU(long j) {
        this.bPS = j;
    }
}
