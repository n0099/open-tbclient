package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a keS = new a();
    private long creatTime = 0;
    private SparseArray<Long> keT = new SparseArray<>();
    private SparseArray<Long> keU = new SparseArray<>();
    private SparseArray<Long> keV = new SparseArray<>();
    private SparseArray<Long> keW = new SparseArray<>();

    private a() {
    }

    public static a cPB() {
        return keS;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long BB(int i) {
        Long l = this.keU.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void B(long j, int i) {
        this.keU.put(i, Long.valueOf(j));
    }

    public long BC(int i) {
        Long l = this.keT.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void C(long j, int i) {
        this.keT.put(i, Long.valueOf(j));
    }

    public long BD(int i) {
        Long l = this.keV.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void D(long j, int i) {
        this.keV.put(i, Long.valueOf(j));
    }

    public long BE(int i) {
        Long l = this.keW.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void E(long j, int i) {
        this.keW.put(i, Long.valueOf(j));
    }
}
