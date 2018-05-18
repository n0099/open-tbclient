package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a dDd = new a();
    private long dDe = 0;
    private SparseArray<Long> dDf = new SparseArray<>();
    private SparseArray<Long> dDg = new SparseArray<>();
    private SparseArray<Long> dDh = new SparseArray<>();
    private SparseArray<Long> dDi = new SparseArray<>();

    private a() {
    }

    public static a axp() {
        return dDd;
    }

    public long getCreateTime() {
        return this.dDe;
    }

    public void setCreateTime(long j) {
        this.dDe = j;
    }

    public long lU(int i) {
        Long l = this.dDg.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dDg.put(i, Long.valueOf(j));
    }

    public long lV(int i) {
        Long l = this.dDf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dDf.put(i, Long.valueOf(j));
    }

    public long lW(int i) {
        Long l = this.dDh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dDh.put(i, Long.valueOf(j));
    }

    public long lX(int i) {
        Long l = this.dDi.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dDi.put(i, Long.valueOf(j));
    }
}
