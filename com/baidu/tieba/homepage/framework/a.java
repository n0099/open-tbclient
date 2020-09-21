package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes21.dex */
public class a {
    private static a iQH = new a();
    private long creatTime = 0;
    private SparseArray<Long> iQI = new SparseArray<>();
    private SparseArray<Long> iQJ = new SparseArray<>();
    private SparseArray<Long> iQK = new SparseArray<>();
    private SparseArray<Long> iQL = new SparseArray<>();

    private a() {
    }

    public static a czV() {
        return iQH;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long Ac(int i) {
        Long l = this.iQJ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void r(long j, int i) {
        this.iQJ.put(i, Long.valueOf(j));
    }

    public long Ad(int i) {
        Long l = this.iQI.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void s(long j, int i) {
        this.iQI.put(i, Long.valueOf(j));
    }

    public long Ae(int i) {
        Long l = this.iQK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void t(long j, int i) {
        this.iQK.put(i, Long.valueOf(j));
    }

    public long Af(int i) {
        Long l = this.iQL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void u(long j, int i) {
        this.iQL.put(i, Long.valueOf(j));
    }
}
