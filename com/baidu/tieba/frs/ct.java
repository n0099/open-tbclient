package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class ct {
    private long bTe;
    private long bTf;
    private long bTg;
    private long bTh;
    private long bTi;

    public ct(Context context) {
        bi(0L);
        bj(0L);
    }

    public void bi(long j) {
        this.bTe = j;
    }

    public void bj(long j) {
        this.bTf = j;
    }

    public long aci() {
        return this.bTf + this.bTe + this.bTg;
    }

    public void bk(long j) {
        this.bTg = j;
    }

    public void bl(long j) {
        this.bTh = j;
    }

    public long acj() {
        return this.bTh;
    }

    public long ack() {
        return this.bTi;
    }

    public void bm(long j) {
        this.bTi = j;
    }
}
