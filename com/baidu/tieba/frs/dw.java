package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class dw {
    private long bip;
    private long biq;
    private long bir;
    private long bis;

    public dw(Context context) {
        av(0L);
        aw(0L);
    }

    public void av(long j) {
        this.bip = j;
    }

    public void aw(long j) {
        this.biq = j;
    }

    public long Ov() {
        return this.biq + this.bip + this.bir;
    }

    public void ax(long j) {
        this.bir = j;
    }

    public void ay(long j) {
        this.bis = j;
    }

    public long Ow() {
        return this.bis;
    }
}
