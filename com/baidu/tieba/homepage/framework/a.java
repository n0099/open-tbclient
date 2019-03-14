package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a fIL = new a();
    private long fIM = 0;
    private SparseArray<Long> fIN = new SparseArray<>();
    private SparseArray<Long> fIO = new SparseArray<>();
    private SparseArray<Long> fIP = new SparseArray<>();
    private SparseArray<Long> fIQ = new SparseArray<>();

    private a() {
    }

    public static a blQ() {
        return fIL;
    }

    public long getCreateTime() {
        return this.fIM;
    }

    public void setCreateTime(long j) {
        this.fIM = j;
    }

    public long sm(int i) {
        Long l = this.fIO.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.fIO.put(i, Long.valueOf(j));
    }

    public long sn(int i) {
        Long l = this.fIN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.fIN.put(i, Long.valueOf(j));
    }

    public long so(int i) {
        Long l = this.fIP.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.fIP.put(i, Long.valueOf(j));
    }

    public long sp(int i) {
        Long l = this.fIQ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.fIQ.put(i, Long.valueOf(j));
    }
}
