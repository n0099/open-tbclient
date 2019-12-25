package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes6.dex */
public class a {
    private static a gTk = new a();
    private long gTl = 0;
    private SparseArray<Long> gTm = new SparseArray<>();
    private SparseArray<Long> gTn = new SparseArray<>();
    private SparseArray<Long> gTo = new SparseArray<>();
    private SparseArray<Long> gTp = new SparseArray<>();

    private a() {
    }

    public static a bKI() {
        return gTk;
    }

    public long getCreateTime() {
        return this.gTl;
    }

    public void setCreateTime(long j) {
        this.gTl = j;
    }

    public long uL(int i) {
        Long l = this.gTn.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.gTn.put(i, Long.valueOf(j));
    }

    public long uM(int i) {
        Long l = this.gTm.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.gTm.put(i, Long.valueOf(j));
    }

    public long uN(int i) {
        Long l = this.gTo.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.gTo.put(i, Long.valueOf(j));
    }

    public long uO(int i) {
        Long l = this.gTp.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.gTp.put(i, Long.valueOf(j));
    }
}
