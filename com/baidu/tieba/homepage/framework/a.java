package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes6.dex */
public class a {
    private static a ekz = new a();
    private long ekA = 0;
    private SparseArray<Long> ekB = new SparseArray<>();
    private SparseArray<Long> ekC = new SparseArray<>();
    private SparseArray<Long> ekD = new SparseArray<>();
    private SparseArray<Long> ekE = new SparseArray<>();

    private a() {
    }

    public static a aJm() {
        return ekz;
    }

    public long getCreateTime() {
        return this.ekA;
    }

    public void setCreateTime(long j) {
        this.ekA = j;
    }

    public long nD(int i) {
        Long l = this.ekC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ekC.put(i, Long.valueOf(j));
    }

    public long nE(int i) {
        Long l = this.ekB.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.ekB.put(i, Long.valueOf(j));
    }

    public long nF(int i) {
        Long l = this.ekD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void j(long j, int i) {
        this.ekD.put(i, Long.valueOf(j));
    }

    public long nG(int i) {
        Long l = this.ekE.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.ekE.put(i, Long.valueOf(j));
    }
}
