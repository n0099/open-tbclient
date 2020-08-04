package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes16.dex */
public class a {
    private static a itL = new a();
    private long creatTime = 0;
    private SparseArray<Long> itM = new SparseArray<>();
    private SparseArray<Long> itN = new SparseArray<>();
    private SparseArray<Long> itO = new SparseArray<>();
    private SparseArray<Long> itP = new SparseArray<>();

    private a() {
    }

    public static a clF() {
        return itL;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long xh(int i) {
        Long l = this.itN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.itN.put(i, Long.valueOf(j));
    }

    public long xi(int i) {
        Long l = this.itM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.itM.put(i, Long.valueOf(j));
    }

    public long xj(int i) {
        Long l = this.itO.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.itO.put(i, Long.valueOf(j));
    }

    public long xk(int i) {
        Long l = this.itP.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void r(long j, int i) {
        this.itP.put(i, Long.valueOf(j));
    }
}
