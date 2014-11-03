package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cz {
    private long aEu;
    private long aEv;
    private long aEw;

    public cz(Context context) {
        z(0L);
        A(0L);
    }

    public void z(long j) {
        this.aEu = j;
    }

    public long GN() {
        return this.aEu + this.aEv;
    }

    public void A(long j) {
        this.aEv = j;
    }

    public long GO() {
        return this.aEw;
    }

    public void B(long j) {
        this.aEw = j;
    }
}
