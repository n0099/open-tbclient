package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes22.dex */
public class a {
    private static a jxW = new a();
    private long creatTime = 0;
    private SparseArray<Long> jxX = new SparseArray<>();
    private SparseArray<Long> jxY = new SparseArray<>();
    private SparseArray<Long> jxZ = new SparseArray<>();
    private SparseArray<Long> jya = new SparseArray<>();

    private a() {
    }

    public static a cJh() {
        return jxW;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long Bo(int i) {
        Long l = this.jxY.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void z(long j, int i) {
        this.jxY.put(i, Long.valueOf(j));
    }

    public long Bp(int i) {
        Long l = this.jxX.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void A(long j, int i) {
        this.jxX.put(i, Long.valueOf(j));
    }

    public long Bq(int i) {
        Long l = this.jxZ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void B(long j, int i) {
        this.jxZ.put(i, Long.valueOf(j));
    }

    public long Br(int i) {
        Long l = this.jya.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void C(long j, int i) {
        this.jya.put(i, Long.valueOf(j));
    }
}
