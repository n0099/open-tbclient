package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes21.dex */
public class a {
    private static a jyN = new a();
    private long creatTime = 0;
    private SparseArray<Long> jyO = new SparseArray<>();
    private SparseArray<Long> jyP = new SparseArray<>();
    private SparseArray<Long> jyQ = new SparseArray<>();
    private SparseArray<Long> jyR = new SparseArray<>();

    private a() {
    }

    public static a cIM() {
        return jyN;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long BM(int i) {
        Long l = this.jyP.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void z(long j, int i) {
        this.jyP.put(i, Long.valueOf(j));
    }

    public long BN(int i) {
        Long l = this.jyO.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void A(long j, int i) {
        this.jyO.put(i, Long.valueOf(j));
    }

    public long BO(int i) {
        Long l = this.jyQ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void B(long j, int i) {
        this.jyQ.put(i, Long.valueOf(j));
    }

    public long BP(int i) {
        Long l = this.jyR.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void C(long j, int i) {
        this.jyR.put(i, Long.valueOf(j));
    }
}
