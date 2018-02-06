package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a ehp = new a();
    private long ehq = 0;
    private SparseArray<Long> ehr = new SparseArray<>();
    private SparseArray<Long> ehs = new SparseArray<>();
    private SparseArray<Long> eht = new SparseArray<>();
    private SparseArray<Long> ehu = new SparseArray<>();

    private a() {
    }

    public static a aCt() {
        return ehp;
    }

    public long getCreateTime() {
        return this.ehq;
    }

    public void setCreateTime(long j) {
        this.ehq = j;
    }

    public long ov(int i) {
        Long l = this.ehs.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ehs.put(i, Long.valueOf(j));
    }

    public long ow(int i) {
        Long l = this.ehr.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.ehr.put(i, Long.valueOf(j));
    }

    public long ox(int i) {
        Long l = this.eht.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.eht.put(i, Long.valueOf(j));
    }

    public long oy(int i) {
        Long l = this.ehu.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ehu.put(i, Long.valueOf(j));
    }
}
