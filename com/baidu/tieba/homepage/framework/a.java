package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a hYt = new a();
    private long creatTime = 0;
    private SparseArray<Long> hYu = new SparseArray<>();
    private SparseArray<Long> hYv = new SparseArray<>();
    private SparseArray<Long> hYw = new SparseArray<>();
    private SparseArray<Long> hYx = new SparseArray<>();

    private a() {
    }

    public static a ceC() {
        return hYt;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long wh(int i) {
        Long l = this.hYv.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.hYv.put(i, Long.valueOf(j));
    }

    public long wi(int i) {
        Long l = this.hYu.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.hYu.put(i, Long.valueOf(j));
    }

    public long wj(int i) {
        Long l = this.hYw.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.hYw.put(i, Long.valueOf(j));
    }

    public long wk(int i) {
        Long l = this.hYx.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.hYx.put(i, Long.valueOf(j));
    }
}
