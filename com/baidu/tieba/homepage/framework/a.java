package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes7.dex */
public class a {
    private static a gWE = new a();
    private long gWF = 0;
    private SparseArray<Long> gWG = new SparseArray<>();
    private SparseArray<Long> gWH = new SparseArray<>();
    private SparseArray<Long> gWI = new SparseArray<>();
    private SparseArray<Long> gWJ = new SparseArray<>();

    private a() {
    }

    public static a bLN() {
        return gWE;
    }

    public long getCreateTime() {
        return this.gWF;
    }

    public void setCreateTime(long j) {
        this.gWF = j;
    }

    public long uQ(int i) {
        Long l = this.gWH.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void n(long j, int i) {
        this.gWH.put(i, Long.valueOf(j));
    }

    public long uR(int i) {
        Long l = this.gWG.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void o(long j, int i) {
        this.gWG.put(i, Long.valueOf(j));
    }

    public long uS(int i) {
        Long l = this.gWI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void p(long j, int i) {
        this.gWI.put(i, Long.valueOf(j));
    }

    public long uT(int i) {
        Long l = this.gWJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.gWJ.put(i, Long.valueOf(j));
    }
}
