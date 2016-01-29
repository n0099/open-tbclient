package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class eb {
    private long blf;
    private long blg;
    private long blh;
    private long bli;

    public eb(Context context) {
        ax(0L);
        ay(0L);
    }

    public void ax(long j) {
        this.blf = j;
    }

    public void ay(long j) {
        this.blg = j;
    }

    public long Qx() {
        return this.blg + this.blf + this.blh;
    }

    public void az(long j) {
        this.blh = j;
    }

    public void aA(long j) {
        this.bli = j;
    }

    public long Qy() {
        return this.bli;
    }
}
