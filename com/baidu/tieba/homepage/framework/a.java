package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a ecF = new a();
    private long ecG = 0;
    private SparseArray<Long> ecH = new SparseArray<>();
    private SparseArray<Long> ecI = new SparseArray<>();
    private SparseArray<Long> ecJ = new SparseArray<>();
    private SparseArray<Long> ecK = new SparseArray<>();

    private a() {
    }

    public static a aFU() {
        return ecF;
    }

    public long getCreateTime() {
        return this.ecG;
    }

    public void setCreateTime(long j) {
        this.ecG = j;
    }

    public long nf(int i) {
        Long l = this.ecI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ecI.put(i, Long.valueOf(j));
    }

    public long ng(int i) {
        Long l = this.ecH.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.ecH.put(i, Long.valueOf(j));
    }

    public long nh(int i) {
        Long l = this.ecJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void j(long j, int i) {
        this.ecJ.put(i, Long.valueOf(j));
    }

    public long ni(int i) {
        Long l = this.ecK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.ecK.put(i, Long.valueOf(j));
    }
}
