package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes9.dex */
public class a {
    private static a gYF = new a();
    private long gYG = 0;
    private SparseArray<Long> gYH = new SparseArray<>();
    private SparseArray<Long> gYI = new SparseArray<>();
    private SparseArray<Long> gYJ = new SparseArray<>();
    private SparseArray<Long> gYK = new SparseArray<>();

    private a() {
    }

    public static a bNq() {
        return gYF;
    }

    public long getCreateTime() {
        return this.gYG;
    }

    public void setCreateTime(long j) {
        this.gYG = j;
    }

    public long uW(int i) {
        Long l = this.gYI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.gYI.put(i, Long.valueOf(j));
    }

    public long uX(int i) {
        Long l = this.gYH.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.gYH.put(i, Long.valueOf(j));
    }

    public long uY(int i) {
        Long l = this.gYJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.gYJ.put(i, Long.valueOf(j));
    }

    public long uZ(int i) {
        Long l = this.gYK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.gYK.put(i, Long.valueOf(j));
    }
}
