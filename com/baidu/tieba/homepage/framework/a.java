package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a fZv = new a();
    private long fZw = 0;
    private SparseArray<Long> fZx = new SparseArray<>();
    private SparseArray<Long> fZy = new SparseArray<>();
    private SparseArray<Long> fZz = new SparseArray<>();
    private SparseArray<Long> fZA = new SparseArray<>();

    private a() {
    }

    public static a btm() {
        return fZv;
    }

    public long getCreateTime() {
        return this.fZw;
    }

    public void setCreateTime(long j) {
        this.fZw = j;
    }

    public long tp(int i) {
        Long l = this.fZy.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.fZy.put(i, Long.valueOf(j));
    }

    public long tq(int i) {
        Long l = this.fZx.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void l(long j, int i) {
        this.fZx.put(i, Long.valueOf(j));
    }

    public long tr(int i) {
        Long l = this.fZz.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.fZz.put(i, Long.valueOf(j));
    }

    public long ts(int i) {
        Long l = this.fZA.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.fZA.put(i, Long.valueOf(j));
    }
}
