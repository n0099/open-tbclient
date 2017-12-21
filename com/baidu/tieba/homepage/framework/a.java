package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dpp = new a();
    private long dpq = 0;
    private SparseArray<Long> dpr = new SparseArray<>();
    private SparseArray<Long> dps = new SparseArray<>();
    private SparseArray<Long> dpt = new SparseArray<>();
    private SparseArray<Long> dpu = new SparseArray<>();

    private a() {
    }

    public static a atP() {
        return dpp;
    }

    public long getCreateTime() {
        return this.dpq;
    }

    public void setCreateTime(long j) {
        this.dpq = j;
    }

    public long lK(int i) {
        Long l = this.dps.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dps.put(i, Long.valueOf(j));
    }

    public long lL(int i) {
        Long l = this.dpr.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dpr.put(i, Long.valueOf(j));
    }

    public long lM(int i) {
        Long l = this.dpt.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dpt.put(i, Long.valueOf(j));
    }

    public long lN(int i) {
        Long l = this.dpu.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dpu.put(i, Long.valueOf(j));
    }
}
