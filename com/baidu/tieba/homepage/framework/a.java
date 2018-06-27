package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a dRF = new a();
    private long dRG = 0;
    private SparseArray<Long> dRH = new SparseArray<>();
    private SparseArray<Long> dRI = new SparseArray<>();
    private SparseArray<Long> dRJ = new SparseArray<>();
    private SparseArray<Long> dRK = new SparseArray<>();

    private a() {
    }

    public static a aCO() {
        return dRF;
    }

    public long getCreateTime() {
        return this.dRG;
    }

    public void setCreateTime(long j) {
        this.dRG = j;
    }

    public long mn(int i) {
        Long l = this.dRI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dRI.put(i, Long.valueOf(j));
    }

    public long mo(int i) {
        Long l = this.dRH.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dRH.put(i, Long.valueOf(j));
    }

    public long mp(int i) {
        Long l = this.dRJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dRJ.put(i, Long.valueOf(j));
    }

    public long mq(int i) {
        Long l = this.dRK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dRK.put(i, Long.valueOf(j));
    }
}
