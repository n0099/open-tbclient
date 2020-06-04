package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a hZg = new a();
    private long creatTime = 0;
    private SparseArray<Long> hZh = new SparseArray<>();
    private SparseArray<Long> hZi = new SparseArray<>();
    private SparseArray<Long> hZj = new SparseArray<>();
    private SparseArray<Long> hZk = new SparseArray<>();

    private a() {
    }

    public static a ceK() {
        return hZg;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long wj(int i) {
        Long l = this.hZi.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.hZi.put(i, Long.valueOf(j));
    }

    public long wk(int i) {
        Long l = this.hZh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.hZh.put(i, Long.valueOf(j));
    }

    public long wl(int i) {
        Long l = this.hZj.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.hZj.put(i, Long.valueOf(j));
    }

    public long wm(int i) {
        Long l = this.hZk.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.hZk.put(i, Long.valueOf(j));
    }
}
