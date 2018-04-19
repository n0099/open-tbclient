package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a dBZ = new a();
    private long dCa = 0;
    private SparseArray<Long> dCb = new SparseArray<>();
    private SparseArray<Long> dCc = new SparseArray<>();
    private SparseArray<Long> dCd = new SparseArray<>();
    private SparseArray<Long> dCe = new SparseArray<>();

    private a() {
    }

    public static a axq() {
        return dBZ;
    }

    public long getCreateTime() {
        return this.dCa;
    }

    public void setCreateTime(long j) {
        this.dCa = j;
    }

    public long lV(int i) {
        Long l = this.dCc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dCc.put(i, Long.valueOf(j));
    }

    public long lW(int i) {
        Long l = this.dCb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dCb.put(i, Long.valueOf(j));
    }

    public long lX(int i) {
        Long l = this.dCd.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dCd.put(i, Long.valueOf(j));
    }

    public long lY(int i) {
        Long l = this.dCe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.dCe.put(i, Long.valueOf(j));
    }
}
