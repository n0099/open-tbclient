package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dfA = new a();
    private long dfB = 0;
    private SparseArray<Long> dfC = new SparseArray<>();
    private SparseArray<Long> dfD = new SparseArray<>();
    private SparseArray<Long> dfE = new SparseArray<>();
    private SparseArray<Long> dfF = new SparseArray<>();

    private a() {
    }

    public static a arN() {
        return dfA;
    }

    public long getCreateTime() {
        return this.dfB;
    }

    public void setCreateTime(long j) {
        this.dfB = j;
    }

    public long lf(int i) {
        Long l = this.dfD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dfD.put(i, Long.valueOf(j));
    }

    public long lg(int i) {
        Long l = this.dfC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dfC.put(i, Long.valueOf(j));
    }

    public long lh(int i) {
        Long l = this.dfE.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dfE.put(i, Long.valueOf(j));
    }

    public long li(int i) {
        Long l = this.dfF.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dfF.put(i, Long.valueOf(j));
    }
}
