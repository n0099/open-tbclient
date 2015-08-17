package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cn {
    private long aYm;
    private long aYn;
    private long aYo;

    public cn(Context context) {
        U(0L);
        V(0L);
    }

    public void U(long j) {
        this.aYm = j;
    }

    public long Mv() {
        return this.aYm + this.aYn;
    }

    public void V(long j) {
        this.aYn = j;
    }

    public long Mw() {
        return this.aYo;
    }

    public void W(long j) {
        this.aYo = j;
    }
}
