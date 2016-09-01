package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cBy = new a();
    private long cBz = 0;
    private SparseArray<Long> cBA = new SparseArray<>();
    private SparseArray<Long> cBB = new SparseArray<>();
    private SparseArray<Long> cBC = new SparseArray<>();
    private SparseArray<Long> cBD = new SparseArray<>();

    private a() {
    }

    public static a alw() {
        return cBy;
    }

    public long getCreateTime() {
        return this.cBz;
    }

    public void setCreateTime(long j) {
        this.cBz = j;
    }

    public long jK(int i) {
        Long l = this.cBB.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cBB.put(i, Long.valueOf(j));
    }

    public long jL(int i) {
        Long l = this.cBA.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cBA.put(i, Long.valueOf(j));
    }

    public long jM(int i) {
        Long l = this.cBC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cBC.put(i, Long.valueOf(j));
    }

    public long jN(int i) {
        Long l = this.cBD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.cBD.put(i, Long.valueOf(j));
    }
}
