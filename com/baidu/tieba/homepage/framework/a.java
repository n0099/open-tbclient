package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dpl = new a();
    private long dpm = 0;
    private SparseArray<Long> dpn = new SparseArray<>();
    private SparseArray<Long> dpo = new SparseArray<>();
    private SparseArray<Long> dpp = new SparseArray<>();
    private SparseArray<Long> dpq = new SparseArray<>();

    private a() {
    }

    public static a atO() {
        return dpl;
    }

    public long getCreateTime() {
        return this.dpm;
    }

    public void setCreateTime(long j) {
        this.dpm = j;
    }

    public long lK(int i) {
        Long l = this.dpo.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dpo.put(i, Long.valueOf(j));
    }

    public long lL(int i) {
        Long l = this.dpn.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dpn.put(i, Long.valueOf(j));
    }

    public long lM(int i) {
        Long l = this.dpp.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dpp.put(i, Long.valueOf(j));
    }

    public long lN(int i) {
        Long l = this.dpq.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dpq.put(i, Long.valueOf(j));
    }
}
