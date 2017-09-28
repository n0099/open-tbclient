package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cXa = new a();
    private long cXb = 0;
    private SparseArray<Long> cXc = new SparseArray<>();
    private SparseArray<Long> cXd = new SparseArray<>();
    private SparseArray<Long> cXe = new SparseArray<>();
    private SparseArray<Long> cXf = new SparseArray<>();

    private a() {
    }

    public static a apd() {
        return cXa;
    }

    public long getCreateTime() {
        return this.cXb;
    }

    public void setCreateTime(long j) {
        this.cXb = j;
    }

    public long kO(int i) {
        Long l = this.cXd.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cXd.put(i, Long.valueOf(j));
    }

    public long kP(int i) {
        Long l = this.cXc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cXc.put(i, Long.valueOf(j));
    }

    public long kQ(int i) {
        Long l = this.cXe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cXe.put(i, Long.valueOf(j));
    }

    public long kR(int i) {
        Long l = this.cXf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cXf.put(i, Long.valueOf(j));
    }
}
