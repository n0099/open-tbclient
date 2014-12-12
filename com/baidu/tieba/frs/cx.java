package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cx {
    private long aFZ;
    private long aGa;
    private long aGb;

    public cx(Context context) {
        K(0L);
        L(0L);
    }

    public void K(long j) {
        this.aFZ = j;
    }

    public long GT() {
        return this.aFZ + this.aGa;
    }

    public void L(long j) {
        this.aGa = j;
    }

    public long GU() {
        return this.aGb;
    }

    public void M(long j) {
        this.aGb = j;
    }
}
