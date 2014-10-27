package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cz {
    private long aEk;
    private long aEl;
    private long aEm;

    public cz(Context context) {
        z(0L);
        A(0L);
    }

    public void z(long j) {
        this.aEk = j;
    }

    public long GL() {
        return this.aEk + this.aEl;
    }

    public void A(long j) {
        this.aEl = j;
    }

    public long GM() {
        return this.aEm;
    }

    public void B(long j) {
        this.aEm = j;
    }
}
