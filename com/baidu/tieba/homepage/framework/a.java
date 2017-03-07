package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cvi = new a();
    private long cvj = 0;
    private SparseArray<Long> cvk = new SparseArray<>();
    private SparseArray<Long> cvl = new SparseArray<>();
    private SparseArray<Long> cvm = new SparseArray<>();
    private SparseArray<Long> cvn = new SparseArray<>();

    private a() {
    }

    public static a aiz() {
        return cvi;
    }

    public long getCreateTime() {
        return this.cvj;
    }

    public void setCreateTime(long j) {
        this.cvj = j;
    }

    public long jA(int i) {
        Long l = this.cvl.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cvl.put(i, Long.valueOf(j));
    }

    public long jB(int i) {
        Long l = this.cvk.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cvk.put(i, Long.valueOf(j));
    }

    public long jC(int i) {
        Long l = this.cvm.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cvm.put(i, Long.valueOf(j));
    }

    public long jD(int i) {
        Long l = this.cvn.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cvn.put(i, Long.valueOf(j));
    }
}
