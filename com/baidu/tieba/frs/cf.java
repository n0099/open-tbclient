package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cf {
    private long aMH;
    private long aMI;
    private long aMJ;

    public cf(Context context) {
        P(0L);
        Q(0L);
    }

    public void P(long j) {
        this.aMH = j;
    }

    public long KD() {
        return this.aMH + this.aMI;
    }

    public void Q(long j) {
        this.aMI = j;
    }

    public long KE() {
        return this.aMJ;
    }

    public void R(long j) {
        this.aMJ = j;
    }
}
