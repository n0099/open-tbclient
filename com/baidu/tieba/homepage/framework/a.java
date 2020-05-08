package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a hJW = new a();
    private long creatTime = 0;
    private SparseArray<Long> hJX = new SparseArray<>();
    private SparseArray<Long> hJY = new SparseArray<>();
    private SparseArray<Long> hJZ = new SparseArray<>();
    private SparseArray<Long> hKa = new SparseArray<>();

    private a() {
    }

    public static a bYg() {
        return hJW;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long vB(int i) {
        Long l = this.hJY.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.hJY.put(i, Long.valueOf(j));
    }

    public long vC(int i) {
        Long l = this.hJX.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.hJX.put(i, Long.valueOf(j));
    }

    public long vD(int i) {
        Long l = this.hJZ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.hJZ.put(i, Long.valueOf(j));
    }

    public long vE(int i) {
        Long l = this.hKa.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.hKa.put(i, Long.valueOf(j));
    }
}
