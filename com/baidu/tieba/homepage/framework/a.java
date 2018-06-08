package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a dOo = new a();
    private long dOp = 0;
    private SparseArray<Long> dOq = new SparseArray<>();
    private SparseArray<Long> dOr = new SparseArray<>();
    private SparseArray<Long> dOs = new SparseArray<>();
    private SparseArray<Long> dOt = new SparseArray<>();

    private a() {
    }

    public static a aCk() {
        return dOo;
    }

    public long getCreateTime() {
        return this.dOp;
    }

    public void setCreateTime(long j) {
        this.dOp = j;
    }

    public long mg(int i) {
        Long l = this.dOr.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dOr.put(i, Long.valueOf(j));
    }

    public long mh(int i) {
        Long l = this.dOq.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dOq.put(i, Long.valueOf(j));
    }

    public long mi(int i) {
        Long l = this.dOs.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.dOs.put(i, Long.valueOf(j));
    }

    public long mj(int i) {
        Long l = this.dOt.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.dOt.put(i, Long.valueOf(j));
    }
}
