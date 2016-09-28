package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cCc = new a();
    private long cCd = 0;
    private SparseArray<Long> cCe = new SparseArray<>();
    private SparseArray<Long> cCf = new SparseArray<>();
    private SparseArray<Long> cCg = new SparseArray<>();
    private SparseArray<Long> cCh = new SparseArray<>();

    private a() {
    }

    public static a alK() {
        return cCc;
    }

    public long getCreateTime() {
        return this.cCd;
    }

    public void setCreateTime(long j) {
        this.cCd = j;
    }

    public long jQ(int i) {
        Long l = this.cCf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cCf.put(i, Long.valueOf(j));
    }

    public long jR(int i) {
        Long l = this.cCe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cCe.put(i, Long.valueOf(j));
    }

    public long jS(int i) {
        Long l = this.cCg.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cCg.put(i, Long.valueOf(j));
    }

    public long jT(int i) {
        Long l = this.cCh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.cCh.put(i, Long.valueOf(j));
    }
}
