package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a eht = new a();
    private long ehu = 0;
    private SparseArray<Long> ehv = new SparseArray<>();
    private SparseArray<Long> ehw = new SparseArray<>();
    private SparseArray<Long> ehx = new SparseArray<>();
    private SparseArray<Long> ehy = new SparseArray<>();

    private a() {
    }

    public static a aCt() {
        return eht;
    }

    public long getCreateTime() {
        return this.ehu;
    }

    public void setCreateTime(long j) {
        this.ehu = j;
    }

    public long ow(int i) {
        Long l = this.ehw.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ehw.put(i, Long.valueOf(j));
    }

    public long ox(int i) {
        Long l = this.ehv.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.ehv.put(i, Long.valueOf(j));
    }

    public long oy(int i) {
        Long l = this.ehx.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.ehx.put(i, Long.valueOf(j));
    }

    public long oz(int i) {
        Long l = this.ehy.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ehy.put(i, Long.valueOf(j));
    }
}
