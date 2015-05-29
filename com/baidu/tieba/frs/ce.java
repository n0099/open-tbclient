package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class ce {
    private long aOR;
    private long aOS;
    private long aOT;

    public ce(Context context) {
        Q(0L);
        R(0L);
    }

    public void Q(long j) {
        this.aOR = j;
    }

    public long LI() {
        return this.aOR + this.aOS;
    }

    public void R(long j) {
        this.aOS = j;
    }

    public long LJ() {
        return this.aOT;
    }

    public void S(long j) {
        this.aOT = j;
    }
}
