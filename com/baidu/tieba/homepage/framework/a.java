package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cHa = new a();
    private long cHb = 0;
    private SparseArray<Long> cHc = new SparseArray<>();
    private SparseArray<Long> cHd = new SparseArray<>();
    private SparseArray<Long> cHe = new SparseArray<>();
    private SparseArray<Long> cHf = new SparseArray<>();

    private a() {
    }

    public static a amb() {
        return cHa;
    }

    public long getCreateTime() {
        return this.cHb;
    }

    public void setCreateTime(long j) {
        this.cHb = j;
    }

    public long kk(int i) {
        Long l = this.cHd.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cHd.put(i, Long.valueOf(j));
    }

    public long kl(int i) {
        Long l = this.cHc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cHc.put(i, Long.valueOf(j));
    }

    public long km(int i) {
        Long l = this.cHe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cHe.put(i, Long.valueOf(j));
    }

    public long kn(int i) {
        Long l = this.cHf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cHf.put(i, Long.valueOf(j));
    }
}
