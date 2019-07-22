package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a gev = new a();
    private long gew = 0;
    private SparseArray<Long> gex = new SparseArray<>();
    private SparseArray<Long> gey = new SparseArray<>();
    private SparseArray<Long> gez = new SparseArray<>();
    private SparseArray<Long> geA = new SparseArray<>();

    private a() {
    }

    public static a bvp() {
        return gev;
    }

    public long getCreateTime() {
        return this.gew;
    }

    public void setCreateTime(long j) {
        this.gew = j;
    }

    public long tH(int i) {
        Long l = this.gey.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.gey.put(i, Long.valueOf(j));
    }

    public long tI(int i) {
        Long l = this.gex.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void l(long j, int i) {
        this.gex.put(i, Long.valueOf(j));
    }

    public long tJ(int i) {
        Long l = this.gez.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.gez.put(i, Long.valueOf(j));
    }

    public long tK(int i) {
        Long l = this.geA.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.geA.put(i, Long.valueOf(j));
    }
}
