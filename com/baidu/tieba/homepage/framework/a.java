package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a gfl = new a();
    private long gfm = 0;
    private SparseArray<Long> gfn = new SparseArray<>();
    private SparseArray<Long> gfo = new SparseArray<>();
    private SparseArray<Long> gfp = new SparseArray<>();
    private SparseArray<Long> gfq = new SparseArray<>();

    private a() {
    }

    public static a bvC() {
        return gfl;
    }

    public long getCreateTime() {
        return this.gfm;
    }

    public void setCreateTime(long j) {
        this.gfm = j;
    }

    public long tJ(int i) {
        Long l = this.gfo.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.gfo.put(i, Long.valueOf(j));
    }

    public long tK(int i) {
        Long l = this.gfn.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void l(long j, int i) {
        this.gfn.put(i, Long.valueOf(j));
    }

    public long tL(int i) {
        Long l = this.gfp.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.gfp.put(i, Long.valueOf(j));
    }

    public long tM(int i) {
        Long l = this.gfq.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.gfq.put(i, Long.valueOf(j));
    }
}
