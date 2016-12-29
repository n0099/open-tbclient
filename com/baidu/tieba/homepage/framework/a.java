package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cmJ = new a();
    private long cmK = 0;
    private SparseArray<Long> cmL = new SparseArray<>();
    private SparseArray<Long> cmM = new SparseArray<>();
    private SparseArray<Long> cmN = new SparseArray<>();
    private SparseArray<Long> cmO = new SparseArray<>();

    private a() {
    }

    public static a aif() {
        return cmJ;
    }

    public long getCreateTime() {
        return this.cmK;
    }

    public void setCreateTime(long j) {
        this.cmK = j;
    }

    public long ji(int i) {
        Long l = this.cmM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cmM.put(i, Long.valueOf(j));
    }

    public long jj(int i) {
        Long l = this.cmL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cmL.put(i, Long.valueOf(j));
    }

    public long jk(int i) {
        Long l = this.cmN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cmN.put(i, Long.valueOf(j));
    }

    public long jl(int i) {
        Long l = this.cmO.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cmO.put(i, Long.valueOf(j));
    }
}
