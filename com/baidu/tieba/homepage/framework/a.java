package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes22.dex */
public class a {
    private static a jfB = new a();
    private long creatTime = 0;
    private SparseArray<Long> jfC = new SparseArray<>();
    private SparseArray<Long> jfD = new SparseArray<>();
    private SparseArray<Long> jfE = new SparseArray<>();
    private SparseArray<Long> jfF = new SparseArray<>();

    private a() {
    }

    public static a cDz() {
        return jfB;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long AI(int i) {
        Long l = this.jfD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void v(long j, int i) {
        this.jfD.put(i, Long.valueOf(j));
    }

    public long AJ(int i) {
        Long l = this.jfC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void w(long j, int i) {
        this.jfC.put(i, Long.valueOf(j));
    }

    public long AK(int i) {
        Long l = this.jfE.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void x(long j, int i) {
        this.jfE.put(i, Long.valueOf(j));
    }

    public long AL(int i) {
        Long l = this.jfF.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void y(long j, int i) {
        this.jfF.put(i, Long.valueOf(j));
    }
}
