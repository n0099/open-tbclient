package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a fZu = new a();
    private long fZv = 0;
    private SparseArray<Long> fZw = new SparseArray<>();
    private SparseArray<Long> fZx = new SparseArray<>();
    private SparseArray<Long> fZy = new SparseArray<>();
    private SparseArray<Long> fZz = new SparseArray<>();

    private a() {
    }

    public static a btj() {
        return fZu;
    }

    public long getCreateTime() {
        return this.fZv;
    }

    public void setCreateTime(long j) {
        this.fZv = j;
    }

    public long tp(int i) {
        Long l = this.fZx.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.fZx.put(i, Long.valueOf(j));
    }

    public long tq(int i) {
        Long l = this.fZw.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void l(long j, int i) {
        this.fZw.put(i, Long.valueOf(j));
    }

    public long tr(int i) {
        Long l = this.fZy.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.fZy.put(i, Long.valueOf(j));
    }

    public long ts(int i) {
        Long l = this.fZz.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.fZz.put(i, Long.valueOf(j));
    }
}
