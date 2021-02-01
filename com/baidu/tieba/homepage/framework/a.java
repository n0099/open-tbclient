package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a kcB = new a();
    private long creatTime = 0;
    private SparseArray<Long> kcC = new SparseArray<>();
    private SparseArray<Long> kcD = new SparseArray<>();
    private SparseArray<Long> kcE = new SparseArray<>();
    private SparseArray<Long> kcF = new SparseArray<>();

    private a() {
    }

    public static a cPn() {
        return kcB;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long By(int i) {
        Long l = this.kcD.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void B(long j, int i) {
        this.kcD.put(i, Long.valueOf(j));
    }

    public long Bz(int i) {
        Long l = this.kcC.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void C(long j, int i) {
        this.kcC.put(i, Long.valueOf(j));
    }

    public long BA(int i) {
        Long l = this.kcE.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void D(long j, int i) {
        this.kcE.put(i, Long.valueOf(j));
    }

    public long BB(int i) {
        Long l = this.kcF.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void E(long j, int i) {
        this.kcF.put(i, Long.valueOf(j));
    }
}
