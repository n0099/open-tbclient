package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a haa = new a();
    private long hab = 0;
    private SparseArray<Long> hac = new SparseArray<>();
    private SparseArray<Long> had = new SparseArray<>();
    private SparseArray<Long> hae = new SparseArray<>();
    private SparseArray<Long> haf = new SparseArray<>();

    private a() {
    }

    public static a bNH() {
        return haa;
    }

    public long getCreateTime() {
        return this.hab;
    }

    public void setCreateTime(long j) {
        this.hab = j;
    }

    public long vd(int i) {
        Long l = this.had.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.had.put(i, Long.valueOf(j));
    }

    public long ve(int i) {
        Long l = this.hac.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.hac.put(i, Long.valueOf(j));
    }

    public long vf(int i) {
        Long l = this.hae.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.hae.put(i, Long.valueOf(j));
    }

    public long vg(int i) {
        Long l = this.haf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.haf.put(i, Long.valueOf(j));
    }
}
