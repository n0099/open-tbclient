package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    private static a edd = new a();
    private long ede = 0;
    private SparseArray<Long> edf = new SparseArray<>();
    private SparseArray<Long> edg = new SparseArray<>();
    private SparseArray<Long> edh = new SparseArray<>();
    private SparseArray<Long> edi = new SparseArray<>();

    private a() {
    }

    public static a aAZ() {
        return edd;
    }

    public long getCreateTime() {
        return this.ede;
    }

    public void setCreateTime(long j) {
        this.ede = j;
    }

    public long ou(int i) {
        Long l = this.edg.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.edg.put(i, Long.valueOf(j));
    }

    public long ov(int i) {
        Long l = this.edf.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.edf.put(i, Long.valueOf(j));
    }

    public long ow(int i) {
        Long l = this.edh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.edh.put(i, Long.valueOf(j));
    }

    public long ox(int i) {
        Long l = this.edi.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void h(long j, int i) {
        this.edi.put(i, Long.valueOf(j));
    }
}
