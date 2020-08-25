package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes16.dex */
public class a {
    private static a iIa = new a();
    private long creatTime = 0;
    private SparseArray<Long> iIb = new SparseArray<>();
    private SparseArray<Long> iIc = new SparseArray<>();
    private SparseArray<Long> iId = new SparseArray<>();
    private SparseArray<Long> iIe = new SparseArray<>();

    private a() {
    }

    public static a cwo() {
        return iIa;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long zB(int i) {
        Long l = this.iIc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.iIc.put(i, Long.valueOf(j));
    }

    public long zC(int i) {
        Long l = this.iIb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.iIb.put(i, Long.valueOf(j));
    }

    public long zD(int i) {
        Long l = this.iId.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.iId.put(i, Long.valueOf(j));
    }

    public long zE(int i) {
        Long l = this.iIe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void r(long j, int i) {
        this.iIe.put(i, Long.valueOf(j));
    }
}
