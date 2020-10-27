package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes22.dex */
public class a {
    private static a jrZ = new a();
    private long creatTime = 0;
    private SparseArray<Long> jsa = new SparseArray<>();
    private SparseArray<Long> jsb = new SparseArray<>();
    private SparseArray<Long> jsc = new SparseArray<>();
    private SparseArray<Long> jsd = new SparseArray<>();

    private a() {
    }

    public static a cGG() {
        return jrZ;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long Bb(int i) {
        Long l = this.jsb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void v(long j, int i) {
        this.jsb.put(i, Long.valueOf(j));
    }

    public long Bc(int i) {
        Long l = this.jsa.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void w(long j, int i) {
        this.jsa.put(i, Long.valueOf(j));
    }

    public long Bd(int i) {
        Long l = this.jsc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void x(long j, int i) {
        this.jsc.put(i, Long.valueOf(j));
    }

    public long Be(int i) {
        Long l = this.jsd.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void y(long j, int i) {
        this.jsd.put(i, Long.valueOf(j));
    }
}
