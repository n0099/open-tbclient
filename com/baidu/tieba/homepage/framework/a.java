package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a kcP = new a();
    private long creatTime = 0;
    private SparseArray<Long> kcQ = new SparseArray<>();
    private SparseArray<Long> kcR = new SparseArray<>();
    private SparseArray<Long> kcS = new SparseArray<>();
    private SparseArray<Long> kcT = new SparseArray<>();

    private a() {
    }

    public static a cPu() {
        return kcP;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long By(int i) {
        Long l = this.kcR.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void B(long j, int i) {
        this.kcR.put(i, Long.valueOf(j));
    }

    public long Bz(int i) {
        Long l = this.kcQ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void C(long j, int i) {
        this.kcQ.put(i, Long.valueOf(j));
    }

    public long BA(int i) {
        Long l = this.kcS.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void D(long j, int i) {
        this.kcS.put(i, Long.valueOf(j));
    }

    public long BB(int i) {
        Long l = this.kcT.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void E(long j, int i) {
        this.kcT.put(i, Long.valueOf(j));
    }
}
