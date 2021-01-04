package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a jZF = new a();
    private long creatTime = 0;
    private SparseArray<Long> jZG = new SparseArray<>();
    private SparseArray<Long> jZH = new SparseArray<>();
    private SparseArray<Long> jZI = new SparseArray<>();
    private SparseArray<Long> jZJ = new SparseArray<>();

    private a() {
    }

    public static a cRi() {
        return jZF;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long CP(int i) {
        Long l = this.jZH.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void D(long j, int i) {
        this.jZH.put(i, Long.valueOf(j));
    }

    public long CQ(int i) {
        Long l = this.jZG.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void E(long j, int i) {
        this.jZG.put(i, Long.valueOf(j));
    }

    public long CR(int i) {
        Long l = this.jZI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void F(long j, int i) {
        this.jZI.put(i, Long.valueOf(j));
    }

    public long CS(int i) {
        Long l = this.jZJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void G(long j, int i) {
        this.jZJ.put(i, Long.valueOf(j));
    }
}
