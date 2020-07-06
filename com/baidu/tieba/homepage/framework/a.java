package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a inH = new a();
    private long creatTime = 0;
    private SparseArray<Long> inI = new SparseArray<>();
    private SparseArray<Long> inJ = new SparseArray<>();
    private SparseArray<Long> inK = new SparseArray<>();
    private SparseArray<Long> inL = new SparseArray<>();

    private a() {
    }

    public static a cig() {
        return inH;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long wP(int i) {
        Long l = this.inJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.inJ.put(i, Long.valueOf(j));
    }

    public long wQ(int i) {
        Long l = this.inI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.inI.put(i, Long.valueOf(j));
    }

    public long wR(int i) {
        Long l = this.inK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.inK.put(i, Long.valueOf(j));
    }

    public long wS(int i) {
        Long l = this.inL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.inL.put(i, Long.valueOf(j));
    }
}
