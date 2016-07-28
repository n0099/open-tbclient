package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class cx {
    private long bHY;
    private long bHZ;
    private long bIa;
    private long bIb;
    private long bIc;

    public cx(Context context) {
        aM(0L);
        aN(0L);
    }

    public void aM(long j) {
        this.bHY = j;
    }

    public void aN(long j) {
        this.bHZ = j;
    }

    public long Xl() {
        return this.bHZ + this.bHY + this.bIa;
    }

    public void aO(long j) {
        this.bIa = j;
    }

    public void aP(long j) {
        this.bIb = j;
    }

    public long Xm() {
        return this.bIb;
    }

    public long Xn() {
        return this.bIc;
    }

    public void aQ(long j) {
        this.bIc = j;
    }
}
