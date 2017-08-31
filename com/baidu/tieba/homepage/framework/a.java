package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cZA = new a();
    private long cZB = 0;
    private SparseArray<Long> cZC = new SparseArray<>();
    private SparseArray<Long> cZD = new SparseArray<>();
    private SparseArray<Long> cZE = new SparseArray<>();
    private SparseArray<Long> cZF = new SparseArray<>();

    private a() {
    }

    public static a aqm() {
        return cZA;
    }

    public long getCreateTime() {
        return this.cZB;
    }

    public void setCreateTime(long j) {
        this.cZB = j;
    }

    public long kQ(int i) {
        Long l = this.cZD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cZD.put(i, Long.valueOf(j));
    }

    public long kR(int i) {
        Long l = this.cZC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cZC.put(i, Long.valueOf(j));
    }

    public long kS(int i) {
        Long l = this.cZE.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cZE.put(i, Long.valueOf(j));
    }

    public long kT(int i) {
        Long l = this.cZF.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cZF.put(i, Long.valueOf(j));
    }
}
