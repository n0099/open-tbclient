package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class ct {
    private long bSX;
    private long bSY;
    private long bSZ;
    private long bTa;
    private long bTb;

    public ct(Context context) {
        bi(0L);
        bj(0L);
    }

    public void bi(long j) {
        this.bSX = j;
    }

    public void bj(long j) {
        this.bSY = j;
    }

    public long acv() {
        return this.bSY + this.bSX + this.bSZ;
    }

    public void bk(long j) {
        this.bSZ = j;
    }

    public void bl(long j) {
        this.bTa = j;
    }

    public long acw() {
        return this.bTa;
    }

    public long acx() {
        return this.bTb;
    }

    public void bm(long j) {
        this.bTb = j;
    }
}
