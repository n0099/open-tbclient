package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cHp = new a();
    private long cHq = 0;
    private SparseArray<Long> cHr = new SparseArray<>();
    private SparseArray<Long> cHs = new SparseArray<>();
    private SparseArray<Long> cHt = new SparseArray<>();
    private SparseArray<Long> cHu = new SparseArray<>();

    private a() {
    }

    public static a anF() {
        return cHp;
    }

    public long getCreateTime() {
        return this.cHq;
    }

    public void setCreateTime(long j) {
        this.cHq = j;
    }

    public long jX(int i) {
        Long l = this.cHs.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cHs.put(i, Long.valueOf(j));
    }

    public long jY(int i) {
        Long l = this.cHr.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cHr.put(i, Long.valueOf(j));
    }

    public long jZ(int i) {
        Long l = this.cHt.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cHt.put(i, Long.valueOf(j));
    }

    public long ka(int i) {
        Long l = this.cHu.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.cHu.put(i, Long.valueOf(j));
    }
}
