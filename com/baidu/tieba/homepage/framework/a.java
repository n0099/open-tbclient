package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a gYH = new a();
    private long gYI = 0;
    private SparseArray<Long> gYJ = new SparseArray<>();
    private SparseArray<Long> gYK = new SparseArray<>();
    private SparseArray<Long> gYL = new SparseArray<>();
    private SparseArray<Long> gYM = new SparseArray<>();

    private a() {
    }

    public static a bNs() {
        return gYH;
    }

    public long getCreateTime() {
        return this.gYI;
    }

    public void setCreateTime(long j) {
        this.gYI = j;
    }

    public long uW(int i) {
        Long l = this.gYK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.gYK.put(i, Long.valueOf(j));
    }

    public long uX(int i) {
        Long l = this.gYJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.gYJ.put(i, Long.valueOf(j));
    }

    public long uY(int i) {
        Long l = this.gYL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.gYL.put(i, Long.valueOf(j));
    }

    public long uZ(int i) {
        Long l = this.gYM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.gYM.put(i, Long.valueOf(j));
    }
}
