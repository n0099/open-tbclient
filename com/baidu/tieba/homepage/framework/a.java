package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a czo = new a();
    private long czp = 0;
    private SparseArray<Long> czq = new SparseArray<>();
    private SparseArray<Long> czr = new SparseArray<>();
    private SparseArray<Long> czs = new SparseArray<>();
    private SparseArray<Long> czt = new SparseArray<>();

    private a() {
    }

    public static a aiq() {
        return czo;
    }

    public long getCreateTime() {
        return this.czp;
    }

    public void setCreateTime(long j) {
        this.czp = j;
    }

    public long jZ(int i) {
        Long l = this.czr.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.czr.put(i, Long.valueOf(j));
    }

    public long ka(int i) {
        Long l = this.czq.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.czq.put(i, Long.valueOf(j));
    }

    public long kb(int i) {
        Long l = this.czs.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.czs.put(i, Long.valueOf(j));
    }

    public long kc(int i) {
        Long l = this.czt.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.czt.put(i, Long.valueOf(j));
    }
}
