package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cqq = new a();
    private long cqr = 0;
    private SparseArray<Long> cqs = new SparseArray<>();
    private SparseArray<Long> cqt = new SparseArray<>();
    private SparseArray<Long> cqu = new SparseArray<>();
    private SparseArray<Long> cqv = new SparseArray<>();

    private a() {
    }

    public static a agL() {
        return cqq;
    }

    public long getCreateTime() {
        return this.cqr;
    }

    public void setCreateTime(long j) {
        this.cqr = j;
    }

    public long ji(int i) {
        Long l = this.cqt.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cqt.put(i, Long.valueOf(j));
    }

    public long jj(int i) {
        Long l = this.cqs.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cqs.put(i, Long.valueOf(j));
    }

    public long jk(int i) {
        Long l = this.cqu.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cqu.put(i, Long.valueOf(j));
    }

    public long jl(int i) {
        Long l = this.cqv.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cqv.put(i, Long.valueOf(j));
    }
}
