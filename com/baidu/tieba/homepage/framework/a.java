package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a eby = new a();
    private long ebz = 0;
    private SparseArray<Long> ebA = new SparseArray<>();
    private SparseArray<Long> ebB = new SparseArray<>();
    private SparseArray<Long> ebC = new SparseArray<>();
    private SparseArray<Long> ebD = new SparseArray<>();

    private a() {
    }

    public static a aAS() {
        return eby;
    }

    public long getCreateTime() {
        return this.ebz;
    }

    public void setCreateTime(long j) {
        this.ebz = j;
    }

    public long oB(int i) {
        Long l = this.ebB.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.ebB.put(i, Long.valueOf(j));
    }

    public long oC(int i) {
        Long l = this.ebA.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.ebA.put(i, Long.valueOf(j));
    }

    public long oD(int i) {
        Long l = this.ebC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.ebC.put(i, Long.valueOf(j));
    }

    public long oE(int i) {
        Long l = this.ebD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.ebD.put(i, Long.valueOf(j));
    }
}
