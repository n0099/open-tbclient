package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a ehd = new a();
    private long ehe = 0;
    private SparseArray<Long> ehf = new SparseArray<>();
    private SparseArray<Long> ehg = new SparseArray<>();
    private SparseArray<Long> ehh = new SparseArray<>();
    private SparseArray<Long> ehi = new SparseArray<>();

    private a() {
    }

    public static a aCs() {
        return ehd;
    }

    public long getCreateTime() {
        return this.ehe;
    }

    public void setCreateTime(long j) {
        this.ehe = j;
    }

    public long ov(int i) {
        Long l = this.ehg.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ehg.put(i, Long.valueOf(j));
    }

    public long ow(int i) {
        Long l = this.ehf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.ehf.put(i, Long.valueOf(j));
    }

    public long ox(int i) {
        Long l = this.ehh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.ehh.put(i, Long.valueOf(j));
    }

    public long oy(int i) {
        Long l = this.ehi.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ehi.put(i, Long.valueOf(j));
    }
}
