package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cPF = new a();
    private long cPG = 0;
    private SparseArray<Long> cPH = new SparseArray<>();
    private SparseArray<Long> cPI = new SparseArray<>();
    private SparseArray<Long> cPJ = new SparseArray<>();
    private SparseArray<Long> cPK = new SparseArray<>();

    private a() {
    }

    public static a anR() {
        return cPF;
    }

    public long getCreateTime() {
        return this.cPG;
    }

    public void setCreateTime(long j) {
        this.cPG = j;
    }

    public long kt(int i) {
        Long l = this.cPI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cPI.put(i, Long.valueOf(j));
    }

    public long ku(int i) {
        Long l = this.cPH.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cPH.put(i, Long.valueOf(j));
    }

    public long kv(int i) {
        Long l = this.cPJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cPJ.put(i, Long.valueOf(j));
    }

    public long kw(int i) {
        Long l = this.cPK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cPK.put(i, Long.valueOf(j));
    }
}
