package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dav = new a();
    private long daw = 0;
    private SparseArray<Long> dax = new SparseArray<>();
    private SparseArray<Long> daz = new SparseArray<>();
    private SparseArray<Long> daA = new SparseArray<>();
    private SparseArray<Long> daB = new SparseArray<>();

    private a() {
    }

    public static a aqx() {
        return dav;
    }

    public long getCreateTime() {
        return this.daw;
    }

    public void setCreateTime(long j) {
        this.daw = j;
    }

    public long kS(int i) {
        Long l = this.daz.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.daz.put(i, Long.valueOf(j));
    }

    public long kT(int i) {
        Long l = this.dax.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.dax.put(i, Long.valueOf(j));
    }

    public long kU(int i) {
        Long l = this.daA.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.daA.put(i, Long.valueOf(j));
    }

    public long kV(int i) {
        Long l = this.daB.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.daB.put(i, Long.valueOf(j));
    }
}
