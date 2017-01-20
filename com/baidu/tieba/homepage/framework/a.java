package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a ctJ = new a();
    private long ctK = 0;
    private SparseArray<Long> ctL = new SparseArray<>();
    private SparseArray<Long> ctM = new SparseArray<>();
    private SparseArray<Long> ctN = new SparseArray<>();
    private SparseArray<Long> ctO = new SparseArray<>();

    private a() {
    }

    public static a ajm() {
        return ctJ;
    }

    public long getCreateTime() {
        return this.ctK;
    }

    public void setCreateTime(long j) {
        this.ctK = j;
    }

    public long jV(int i) {
        Long l = this.ctM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.ctM.put(i, Long.valueOf(j));
    }

    public long jW(int i) {
        Long l = this.ctL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.ctL.put(i, Long.valueOf(j));
    }

    public long jX(int i) {
        Long l = this.ctN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ctN.put(i, Long.valueOf(j));
    }

    public long jY(int i) {
        Long l = this.ctO.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.ctO.put(i, Long.valueOf(j));
    }
}
