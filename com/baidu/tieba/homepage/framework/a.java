package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a ecI = new a();
    private long ecJ = 0;
    private SparseArray<Long> ecK = new SparseArray<>();
    private SparseArray<Long> ecL = new SparseArray<>();
    private SparseArray<Long> ecM = new SparseArray<>();
    private SparseArray<Long> ecN = new SparseArray<>();

    private a() {
    }

    public static a aAU() {
        return ecI;
    }

    public long getCreateTime() {
        return this.ecJ;
    }

    public void setCreateTime(long j) {
        this.ecJ = j;
    }

    public long ou(int i) {
        Long l = this.ecL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ecL.put(i, Long.valueOf(j));
    }

    public long ov(int i) {
        Long l = this.ecK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.ecK.put(i, Long.valueOf(j));
    }

    public long ow(int i) {
        Long l = this.ecM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.ecM.put(i, Long.valueOf(j));
    }

    public long ox(int i) {
        Long l = this.ecN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ecN.put(i, Long.valueOf(j));
    }
}
