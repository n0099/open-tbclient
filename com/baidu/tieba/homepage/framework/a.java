package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a fIz = new a();
    private long fIA = 0;
    private SparseArray<Long> fIB = new SparseArray<>();
    private SparseArray<Long> fIC = new SparseArray<>();
    private SparseArray<Long> fID = new SparseArray<>();
    private SparseArray<Long> fIE = new SparseArray<>();

    private a() {
    }

    public static a blN() {
        return fIz;
    }

    public long getCreateTime() {
        return this.fIA;
    }

    public void setCreateTime(long j) {
        this.fIA = j;
    }

    public long si(int i) {
        Long l = this.fIC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.fIC.put(i, Long.valueOf(j));
    }

    public long sj(int i) {
        Long l = this.fIB.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.fIB.put(i, Long.valueOf(j));
    }

    public long sk(int i) {
        Long l = this.fID.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.fID.put(i, Long.valueOf(j));
    }

    public long sl(int i) {
        Long l = this.fIE.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.fIE.put(i, Long.valueOf(j));
    }
}
