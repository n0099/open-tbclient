package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes16.dex */
public class a {
    private static a iIg = new a();
    private long creatTime = 0;
    private SparseArray<Long> iIh = new SparseArray<>();
    private SparseArray<Long> iIi = new SparseArray<>();
    private SparseArray<Long> iIj = new SparseArray<>();
    private SparseArray<Long> iIk = new SparseArray<>();

    private a() {
    }

    public static a cwp() {
        return iIg;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long zB(int i) {
        Long l = this.iIi.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.iIi.put(i, Long.valueOf(j));
    }

    public long zC(int i) {
        Long l = this.iIh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.iIh.put(i, Long.valueOf(j));
    }

    public long zD(int i) {
        Long l = this.iIj.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.iIj.put(i, Long.valueOf(j));
    }

    public long zE(int i) {
        Long l = this.iIk.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void r(long j, int i) {
        this.iIk.put(i, Long.valueOf(j));
    }
}
