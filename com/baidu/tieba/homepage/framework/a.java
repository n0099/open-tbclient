package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes6.dex */
public class a {
    private static a ewk = new a();
    private long ewl = 0;
    private SparseArray<Long> ewm = new SparseArray<>();
    private SparseArray<Long> ewn = new SparseArray<>();
    private SparseArray<Long> ewo = new SparseArray<>();
    private SparseArray<Long> ewp = new SparseArray<>();

    private a() {
    }

    public static a aLO() {
        return ewk;
    }

    public long getCreateTime() {
        return this.ewl;
    }

    public void setCreateTime(long j) {
        this.ewl = j;
    }

    public long oD(int i) {
        Long l = this.ewn.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ewn.put(i, Long.valueOf(j));
    }

    public long oE(int i) {
        Long l = this.ewm.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void i(long j, int i) {
        this.ewm.put(i, Long.valueOf(j));
    }

    public long oF(int i) {
        Long l = this.ewo.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void j(long j, int i) {
        this.ewo.put(i, Long.valueOf(j));
    }

    public long oG(int i) {
        Long l = this.ewp.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void k(long j, int i) {
        this.ewp.put(i, Long.valueOf(j));
    }
}
