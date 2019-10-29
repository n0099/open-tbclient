package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a ggz = new a();
    private long ggA = 0;
    private SparseArray<Long> ggB = new SparseArray<>();
    private SparseArray<Long> ggC = new SparseArray<>();
    private SparseArray<Long> ggD = new SparseArray<>();
    private SparseArray<Long> ggE = new SparseArray<>();

    private a() {
    }

    public static a btv() {
        return ggz;
    }

    public long getCreateTime() {
        return this.ggA;
    }

    public void setCreateTime(long j) {
        this.ggA = j;
    }

    public long sI(int i) {
        Long l = this.ggC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.ggC.put(i, Long.valueOf(j));
    }

    public long sJ(int i) {
        Long l = this.ggB.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.ggB.put(i, Long.valueOf(j));
    }

    public long sK(int i) {
        Long l = this.ggD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.ggD.put(i, Long.valueOf(j));
    }

    public long sL(int i) {
        Long l = this.ggE.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.ggE.put(i, Long.valueOf(j));
    }
}
