package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes6.dex */
public class a {
    private static a esN = new a();
    private long esO = 0;
    private SparseArray<Long> esP = new SparseArray<>();
    private SparseArray<Long> esQ = new SparseArray<>();
    private SparseArray<Long> esR = new SparseArray<>();
    private SparseArray<Long> esS = new SparseArray<>();

    private a() {
    }

    public static a aKB() {
        return esN;
    }

    public long getCreateTime() {
        return this.esO;
    }

    public void setCreateTime(long j) {
        this.esO = j;
    }

    public long op(int i) {
        Long l = this.esQ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.esQ.put(i, Long.valueOf(j));
    }

    public long oq(int i) {
        Long l = this.esP.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.esP.put(i, Long.valueOf(j));
    }

    public long or(int i) {
        Long l = this.esR.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void j(long j, int i) {
        this.esR.put(i, Long.valueOf(j));
    }

    public long os(int i) {
        Long l = this.esS.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.esS.put(i, Long.valueOf(j));
    }
}
