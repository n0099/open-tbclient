package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dfg = new a();
    private long dfh = 0;
    private SparseArray<Long> dfi = new SparseArray<>();
    private SparseArray<Long> dfj = new SparseArray<>();
    private SparseArray<Long> dfk = new SparseArray<>();
    private SparseArray<Long> dfl = new SparseArray<>();

    private a() {
    }

    public static a arx() {
        return dfg;
    }

    public long getCreateTime() {
        return this.dfh;
    }

    public void setCreateTime(long j) {
        this.dfh = j;
    }

    public long lf(int i) {
        Long l = this.dfj.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dfj.put(i, Long.valueOf(j));
    }

    public long lg(int i) {
        Long l = this.dfi.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dfi.put(i, Long.valueOf(j));
    }

    public long lh(int i) {
        Long l = this.dfk.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dfk.put(i, Long.valueOf(j));
    }

    public long li(int i) {
        Long l = this.dfl.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dfl.put(i, Long.valueOf(j));
    }
}
