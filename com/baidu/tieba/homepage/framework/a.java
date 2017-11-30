package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dog = new a();
    private long doh = 0;
    private SparseArray<Long> doi = new SparseArray<>();
    private SparseArray<Long> doj = new SparseArray<>();
    private SparseArray<Long> dok = new SparseArray<>();
    private SparseArray<Long> dol = new SparseArray<>();

    private a() {
    }

    public static a atG() {
        return dog;
    }

    public long getCreateTime() {
        return this.doh;
    }

    public void setCreateTime(long j) {
        this.doh = j;
    }

    public long lD(int i) {
        Long l = this.doj.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.doj.put(i, Long.valueOf(j));
    }

    public long lE(int i) {
        Long l = this.doi.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.doi.put(i, Long.valueOf(j));
    }

    public long lF(int i) {
        Long l = this.dok.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dok.put(i, Long.valueOf(j));
    }

    public long lG(int i) {
        Long l = this.dol.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dol.put(i, Long.valueOf(j));
    }
}
