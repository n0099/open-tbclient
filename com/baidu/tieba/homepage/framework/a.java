package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a ctI = new a();
    private long ctJ = 0;
    private SparseArray<Long> ctK = new SparseArray<>();
    private SparseArray<Long> ctL = new SparseArray<>();
    private SparseArray<Long> ctM = new SparseArray<>();
    private SparseArray<Long> ctN = new SparseArray<>();

    private a() {
    }

    public static a ait() {
        return ctI;
    }

    public long getCreateTime() {
        return this.ctJ;
    }

    public void setCreateTime(long j) {
        this.ctJ = j;
    }

    public long jB(int i) {
        Long l = this.ctL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.ctL.put(i, Long.valueOf(j));
    }

    public long jC(int i) {
        Long l = this.ctK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.ctK.put(i, Long.valueOf(j));
    }

    public long jD(int i) {
        Long l = this.ctM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ctM.put(i, Long.valueOf(j));
    }

    public long jE(int i) {
        Long l = this.ctN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.ctN.put(i, Long.valueOf(j));
    }
}
