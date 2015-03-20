package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cf {
    private long aMw;
    private long aMx;
    private long aMy;

    public cf(Context context) {
        P(0L);
        Q(0L);
    }

    public void P(long j) {
        this.aMw = j;
    }

    public long Kt() {
        return this.aMw + this.aMx;
    }

    public void Q(long j) {
        this.aMx = j;
    }

    public long Ku() {
        return this.aMy;
    }

    public void R(long j) {
        this.aMy = j;
    }
}
