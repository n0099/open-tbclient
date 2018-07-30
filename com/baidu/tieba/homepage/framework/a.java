package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a dVr = new a();
    private long dVs = 0;
    private SparseArray<Long> dVt = new SparseArray<>();
    private SparseArray<Long> dVu = new SparseArray<>();
    private SparseArray<Long> dVv = new SparseArray<>();
    private SparseArray<Long> dVw = new SparseArray<>();

    private a() {
    }

    public static a aDK() {
        return dVr;
    }

    public long getCreateTime() {
        return this.dVs;
    }

    public void setCreateTime(long j) {
        this.dVs = j;
    }

    public long mB(int i) {
        Long l = this.dVu.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dVu.put(i, Long.valueOf(j));
    }

    public long mC(int i) {
        Long l = this.dVt.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dVt.put(i, Long.valueOf(j));
    }

    public long mD(int i) {
        Long l = this.dVv.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dVv.put(i, Long.valueOf(j));
    }

    public long mE(int i) {
        Long l = this.dVw.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dVw.put(i, Long.valueOf(j));
    }
}
