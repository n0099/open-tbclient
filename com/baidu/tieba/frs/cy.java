package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cy {
    private long aHj;
    private long aHk;
    private long aHl;

    public cy(Context context) {
        K(0L);
        L(0L);
    }

    public void K(long j) {
        this.aHj = j;
    }

    public long Hr() {
        return this.aHj + this.aHk;
    }

    public void L(long j) {
        this.aHk = j;
    }

    public long Hs() {
        return this.aHl;
    }

    public void M(long j) {
        this.aHl = j;
    }
}
