package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes22.dex */
public class a {
    private static a jMp = new a();
    private long creatTime = 0;
    private SparseArray<Long> jMq = new SparseArray<>();
    private SparseArray<Long> jMr = new SparseArray<>();
    private SparseArray<Long> jMs = new SparseArray<>();
    private SparseArray<Long> jMt = new SparseArray<>();

    private a() {
    }

    public static a cOb() {
        return jMp;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long CB(int i) {
        Long l = this.jMr.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void B(long j, int i) {
        this.jMr.put(i, Long.valueOf(j));
    }

    public long CC(int i) {
        Long l = this.jMq.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void C(long j, int i) {
        this.jMq.put(i, Long.valueOf(j));
    }

    public long CD(int i) {
        Long l = this.jMs.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void D(long j, int i) {
        this.jMs.put(i, Long.valueOf(j));
    }

    public long CE(int i) {
        Long l = this.jMt.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void E(long j, int i) {
        this.jMt.put(i, Long.valueOf(j));
    }
}
