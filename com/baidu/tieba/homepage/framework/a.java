package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a dBW = new a();
    private long dBX = 0;
    private SparseArray<Long> dBY = new SparseArray<>();
    private SparseArray<Long> dBZ = new SparseArray<>();
    private SparseArray<Long> dCa = new SparseArray<>();
    private SparseArray<Long> dCb = new SparseArray<>();

    private a() {
    }

    public static a axq() {
        return dBW;
    }

    public long getCreateTime() {
        return this.dBX;
    }

    public void setCreateTime(long j) {
        this.dBX = j;
    }

    public long lV(int i) {
        Long l = this.dBZ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dBZ.put(i, Long.valueOf(j));
    }

    public long lW(int i) {
        Long l = this.dBY.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dBY.put(i, Long.valueOf(j));
    }

    public long lX(int i) {
        Long l = this.dCa.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dCa.put(i, Long.valueOf(j));
    }

    public long lY(int i) {
        Long l = this.dCb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.dCb.put(i, Long.valueOf(j));
    }
}
