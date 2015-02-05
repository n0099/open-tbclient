package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cy {
    private long aHg;
    private long aHh;
    private long aHi;

    public cy(Context context) {
        K(0L);
        L(0L);
    }

    public void K(long j) {
        this.aHg = j;
    }

    public long Hl() {
        return this.aHg + this.aHh;
    }

    public void L(long j) {
        this.aHh = j;
    }

    public long Hm() {
        return this.aHi;
    }

    public void M(long j) {
        this.aHi = j;
    }
}
