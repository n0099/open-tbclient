package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class dg {
    private long aYd;
    private long aYe;
    private long aYf;

    public dg(Context context) {
        ae(0L);
        af(0L);
    }

    public void ae(long j) {
        this.aYd = j;
    }

    public long Mt() {
        return this.aYd + this.aYe;
    }

    public void af(long j) {
        this.aYe = j;
    }

    public long Mu() {
        return this.aYf;
    }

    public void ag(long j) {
        this.aYf = j;
    }
}
