package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class dw {
    private long bev;
    private long bew;
    private long bex;
    private long bey;

    public dw(Context context) {
        au(0L);
        av(0L);
    }

    public void au(long j) {
        this.bev = j;
    }

    public void av(long j) {
        this.bew = j;
    }

    public long Oc() {
        return this.bew + this.bev + this.bex;
    }

    public void aw(long j) {
        this.bex = j;
    }

    public void ax(long j) {
        this.bey = j;
    }

    public long Od() {
        return this.bey;
    }
}
