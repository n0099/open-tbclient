package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a jVa = new a();
    private long creatTime = 0;
    private SparseArray<Long> jVb = new SparseArray<>();
    private SparseArray<Long> jVc = new SparseArray<>();
    private SparseArray<Long> jVd = new SparseArray<>();
    private SparseArray<Long> jVe = new SparseArray<>();

    private a() {
    }

    public static a cNr() {
        return jVa;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long Bi(int i) {
        Long l = this.jVc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void D(long j, int i) {
        this.jVc.put(i, Long.valueOf(j));
    }

    public long Bj(int i) {
        Long l = this.jVb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void E(long j, int i) {
        this.jVb.put(i, Long.valueOf(j));
    }

    public long Bk(int i) {
        Long l = this.jVd.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void F(long j, int i) {
        this.jVd.put(i, Long.valueOf(j));
    }

    public long Bl(int i) {
        Long l = this.jVe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void G(long j, int i) {
        this.jVe.put(i, Long.valueOf(j));
    }
}
