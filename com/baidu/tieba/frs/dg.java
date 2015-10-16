package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class dg {
    private long aYo;
    private long aYp;
    private long aYq;

    public dg(Context context) {
        ao(0L);
        ap(0L);
    }

    public void ao(long j) {
        this.aYo = j;
    }

    public long Mt() {
        return this.aYo + this.aYp;
    }

    public void ap(long j) {
        this.aYp = j;
    }

    public long Mu() {
        return this.aYq;
    }

    public void aq(long j) {
        this.aYq = j;
    }
}
