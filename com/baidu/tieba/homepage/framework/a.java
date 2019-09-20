package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a ghc = new a();
    private long ghd = 0;
    private SparseArray<Long> ghe = new SparseArray<>();
    private SparseArray<Long> ghf = new SparseArray<>();
    private SparseArray<Long> ghg = new SparseArray<>();
    private SparseArray<Long> ghh = new SparseArray<>();

    private a() {
    }

    public static a bwq() {
        return ghc;
    }

    public long getCreateTime() {
        return this.ghd;
    }

    public void setCreateTime(long j) {
        this.ghd = j;
    }

    public long tN(int i) {
        Long l = this.ghf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.ghf.put(i, Long.valueOf(j));
    }

    public long tO(int i) {
        Long l = this.ghe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void l(long j, int i) {
        this.ghe.put(i, Long.valueOf(j));
    }

    public long tP(int i) {
        Long l = this.ghg.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.ghg.put(i, Long.valueOf(j));
    }

    public long tQ(int i) {
        Long l = this.ghh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.ghh.put(i, Long.valueOf(j));
    }
}
