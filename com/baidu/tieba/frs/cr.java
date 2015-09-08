package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cr {
    private long aYB;
    private long aYC;
    private long aYD;

    public cr(Context context) {
        V(0L);
        W(0L);
    }

    public void V(long j) {
        this.aYB = j;
    }

    public long Mu() {
        return this.aYB + this.aYC;
    }

    public void W(long j) {
        this.aYC = j;
    }

    public long Mv() {
        return this.aYD;
    }

    public void X(long j) {
        this.aYD = j;
    }
}
