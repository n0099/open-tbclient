package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes6.dex */
public class a {
    private static a elS = new a();
    private long elT = 0;
    private SparseArray<Long> elU = new SparseArray<>();
    private SparseArray<Long> elV = new SparseArray<>();
    private SparseArray<Long> elW = new SparseArray<>();
    private SparseArray<Long> elX = new SparseArray<>();

    private a() {
    }

    public static a aIK() {
        return elS;
    }

    public long getCreateTime() {
        return this.elT;
    }

    public void setCreateTime(long j) {
        this.elT = j;
    }

    public long nV(int i) {
        Long l = this.elV.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.elV.put(i, Long.valueOf(j));
    }

    public long nW(int i) {
        Long l = this.elU.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.elU.put(i, Long.valueOf(j));
    }

    public long nX(int i) {
        Long l = this.elW.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void j(long j, int i) {
        this.elW.put(i, Long.valueOf(j));
    }

    public long nY(int i) {
        Long l = this.elX.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.elX.put(i, Long.valueOf(j));
    }
}
