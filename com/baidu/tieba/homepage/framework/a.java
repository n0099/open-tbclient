package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a gYT = new a();
    private long gYU = 0;
    private SparseArray<Long> gYV = new SparseArray<>();
    private SparseArray<Long> gYW = new SparseArray<>();
    private SparseArray<Long> gYX = new SparseArray<>();
    private SparseArray<Long> gYY = new SparseArray<>();

    private a() {
    }

    public static a bNt() {
        return gYT;
    }

    public long getCreateTime() {
        return this.gYU;
    }

    public void setCreateTime(long j) {
        this.gYU = j;
    }

    public long uW(int i) {
        Long l = this.gYW.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.gYW.put(i, Long.valueOf(j));
    }

    public long uX(int i) {
        Long l = this.gYV.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.gYV.put(i, Long.valueOf(j));
    }

    public long uY(int i) {
        Long l = this.gYX.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.gYX.put(i, Long.valueOf(j));
    }

    public long uZ(int i) {
        Long l = this.gYY.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.gYY.put(i, Long.valueOf(j));
    }
}
