package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a csW = new a();
    private long csX = 0;
    private SparseArray<Long> csY = new SparseArray<>();
    private SparseArray<Long> csZ = new SparseArray<>();
    private SparseArray<Long> cta = new SparseArray<>();
    private SparseArray<Long> ctb = new SparseArray<>();

    private a() {
    }

    public static a ahb() {
        return csW;
    }

    public long getCreateTime() {
        return this.csX;
    }

    public void setCreateTime(long j) {
        this.csX = j;
    }

    public long jA(int i) {
        Long l = this.csZ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void b(long j, int i) {
        this.csZ.put(i, Long.valueOf(j));
    }

    public long jB(int i) {
        Long l = this.csY.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.csY.put(i, Long.valueOf(j));
    }

    public long jC(int i) {
        Long l = this.cta.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cta.put(i, Long.valueOf(j));
    }

    public long jD(int i) {
        Long l = this.ctb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ctb.put(i, Long.valueOf(j));
    }
}
