package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class dg {
    private long aYo;
    private long aYp;
    private long aYq;

    public dg(Context context) {
        am(0L);
        an(0L);
    }

    public void am(long j) {
        this.aYo = j;
    }

    public long Mp() {
        return this.aYo + this.aYp;
    }

    public void an(long j) {
        this.aYp = j;
    }

    public long Mq() {
        return this.aYq;
    }

    public void ao(long j) {
        this.aYq = j;
    }
}
