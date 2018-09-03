package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a dVm = new a();
    private long dVn = 0;
    private SparseArray<Long> dVo = new SparseArray<>();
    private SparseArray<Long> dVp = new SparseArray<>();
    private SparseArray<Long> dVq = new SparseArray<>();
    private SparseArray<Long> dVr = new SparseArray<>();

    private a() {
    }

    public static a aDH() {
        return dVm;
    }

    public long getCreateTime() {
        return this.dVn;
    }

    public void setCreateTime(long j) {
        this.dVn = j;
    }

    public long mB(int i) {
        Long l = this.dVp.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dVp.put(i, Long.valueOf(j));
    }

    public long mC(int i) {
        Long l = this.dVo.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dVo.put(i, Long.valueOf(j));
    }

    public long mD(int i) {
        Long l = this.dVq.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dVq.put(i, Long.valueOf(j));
    }

    public long mE(int i) {
        Long l = this.dVr.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dVr.put(i, Long.valueOf(j));
    }
}
