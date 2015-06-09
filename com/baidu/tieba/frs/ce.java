package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class ce {
    private long aOS;
    private long aOT;
    private long aOU;

    public ce(Context context) {
        Q(0L);
        R(0L);
    }

    public void Q(long j) {
        this.aOS = j;
    }

    public long LJ() {
        return this.aOS + this.aOT;
    }

    public void R(long j) {
        this.aOT = j;
    }

    public long LK() {
        return this.aOU;
    }

    public void S(long j) {
        this.aOU = j;
    }
}
