package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cSX = new a();
    private long cSY = 0;
    private SparseArray<Long> cSZ = new SparseArray<>();
    private SparseArray<Long> cTa = new SparseArray<>();
    private SparseArray<Long> cTb = new SparseArray<>();
    private SparseArray<Long> cTc = new SparseArray<>();

    private a() {
    }

    public static a aoE() {
        return cSX;
    }

    public long getCreateTime() {
        return this.cSY;
    }

    public void setCreateTime(long j) {
        this.cSY = j;
    }

    public long kC(int i) {
        Long l = this.cTa.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cTa.put(i, Long.valueOf(j));
    }

    public long kD(int i) {
        Long l = this.cSZ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cSZ.put(i, Long.valueOf(j));
    }

    public long kE(int i) {
        Long l = this.cTb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cTb.put(i, Long.valueOf(j));
    }

    public long kF(int i) {
        Long l = this.cTc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cTc.put(i, Long.valueOf(j));
    }
}
