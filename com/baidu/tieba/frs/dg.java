package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class dg {
    private long aYx;
    private long aYy;
    private long aYz;

    public dg(Context context) {
        am(0L);
        an(0L);
    }

    public void am(long j) {
        this.aYx = j;
    }

    public long MF() {
        return this.aYx + this.aYy;
    }

    public void an(long j) {
        this.aYy = j;
    }

    public long MG() {
        return this.aYz;
    }

    public void ao(long j) {
        this.aYz = j;
    }
}
