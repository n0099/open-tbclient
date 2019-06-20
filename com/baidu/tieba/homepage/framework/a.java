package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a fZx = new a();
    private long fZy = 0;
    private SparseArray<Long> fZz = new SparseArray<>();
    private SparseArray<Long> fZA = new SparseArray<>();
    private SparseArray<Long> fZB = new SparseArray<>();
    private SparseArray<Long> fZC = new SparseArray<>();

    private a() {
    }

    public static a btn() {
        return fZx;
    }

    public long getCreateTime() {
        return this.fZy;
    }

    public void setCreateTime(long j) {
        this.fZy = j;
    }

    public long tp(int i) {
        Long l = this.fZA.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.fZA.put(i, Long.valueOf(j));
    }

    public long tq(int i) {
        Long l = this.fZz.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void l(long j, int i) {
        this.fZz.put(i, Long.valueOf(j));
    }

    public long tr(int i) {
        Long l = this.fZB.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.fZB.put(i, Long.valueOf(j));
    }

    public long ts(int i) {
        Long l = this.fZC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.fZC.put(i, Long.valueOf(j));
    }
}
