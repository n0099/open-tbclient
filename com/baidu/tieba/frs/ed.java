package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class ed {
    private long blG;
    private long blH;
    private long blI;
    private long blJ;
    private long blK;

    public ed(Context context) {
        aB(0L);
        aC(0L);
    }

    public void aB(long j) {
        this.blG = j;
    }

    public void aC(long j) {
        this.blH = j;
    }

    public long Rz() {
        return this.blH + this.blG + this.blI;
    }

    public void aD(long j) {
        this.blI = j;
    }

    public void aE(long j) {
        this.blJ = j;
    }

    public long RA() {
        return this.blJ;
    }

    public long RB() {
        return this.blK;
    }

    public void aF(long j) {
        this.blK = j;
    }
}
