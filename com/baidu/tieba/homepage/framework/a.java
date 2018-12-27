package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes6.dex */
public class a {
    private static a evE = new a();
    private long evF = 0;
    private SparseArray<Long> evG = new SparseArray<>();
    private SparseArray<Long> evH = new SparseArray<>();
    private SparseArray<Long> evI = new SparseArray<>();
    private SparseArray<Long> evJ = new SparseArray<>();

    private a() {
    }

    public static a aLq() {
        return evE;
    }

    public long getCreateTime() {
        return this.evF;
    }

    public void setCreateTime(long j) {
        this.evF = j;
    }

    public long oC(int i) {
        Long l = this.evH.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.evH.put(i, Long.valueOf(j));
    }

    public long oD(int i) {
        Long l = this.evG.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.evG.put(i, Long.valueOf(j));
    }

    public long oE(int i) {
        Long l = this.evI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void j(long j, int i) {
        this.evI.put(i, Long.valueOf(j));
    }

    public long oF(int i) {
        Long l = this.evJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.evJ.put(i, Long.valueOf(j));
    }
}
