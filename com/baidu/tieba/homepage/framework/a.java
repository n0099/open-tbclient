package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a fIM = new a();
    private long fIN = 0;
    private SparseArray<Long> fIO = new SparseArray<>();
    private SparseArray<Long> fIP = new SparseArray<>();
    private SparseArray<Long> fIQ = new SparseArray<>();
    private SparseArray<Long> fIR = new SparseArray<>();

    private a() {
    }

    public static a blQ() {
        return fIM;
    }

    public long getCreateTime() {
        return this.fIN;
    }

    public void setCreateTime(long j) {
        this.fIN = j;
    }

    public long sm(int i) {
        Long l = this.fIP.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.fIP.put(i, Long.valueOf(j));
    }

    public long sn(int i) {
        Long l = this.fIO.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.fIO.put(i, Long.valueOf(j));
    }

    public long so(int i) {
        Long l = this.fIQ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.fIQ.put(i, Long.valueOf(j));
    }

    public long sp(int i) {
        Long l = this.fIR.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.fIR.put(i, Long.valueOf(j));
    }
}
