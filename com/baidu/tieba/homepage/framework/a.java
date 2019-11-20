package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {
    private static a gfI = new a();
    private long gfJ = 0;
    private SparseArray<Long> gfK = new SparseArray<>();
    private SparseArray<Long> gfL = new SparseArray<>();
    private SparseArray<Long> gfM = new SparseArray<>();
    private SparseArray<Long> gfN = new SparseArray<>();

    private a() {
    }

    public static a btt() {
        return gfI;
    }

    public long getCreateTime() {
        return this.gfJ;
    }

    public void setCreateTime(long j) {
        this.gfJ = j;
    }

    public long sH(int i) {
        Long l = this.gfL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void m(long j, int i) {
        this.gfL.put(i, Long.valueOf(j));
    }

    public long sI(int i) {
        Long l = this.gfK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.gfK.put(i, Long.valueOf(j));
    }

    public long sJ(int i) {
        Long l = this.gfM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.gfM.put(i, Long.valueOf(j));
    }

    public long sK(int i) {
        Long l = this.gfN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.gfN.put(i, Long.valueOf(j));
    }
}
