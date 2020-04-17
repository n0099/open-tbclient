package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a hJQ = new a();
    private long creatTime = 0;
    private SparseArray<Long> hJR = new SparseArray<>();
    private SparseArray<Long> hJS = new SparseArray<>();
    private SparseArray<Long> hJT = new SparseArray<>();
    private SparseArray<Long> hJU = new SparseArray<>();

    private a() {
    }

    public static a bYi() {
        return hJQ;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long vB(int i) {
        Long l = this.hJS.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.hJS.put(i, Long.valueOf(j));
    }

    public long vC(int i) {
        Long l = this.hJR.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.hJR.put(i, Long.valueOf(j));
    }

    public long vD(int i) {
        Long l = this.hJT.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.hJT.put(i, Long.valueOf(j));
    }

    public long vE(int i) {
        Long l = this.hJU.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.hJU.put(i, Long.valueOf(j));
    }
}
