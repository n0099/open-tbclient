package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cWO = new a();
    private long cWP = 0;
    private SparseArray<Long> cWQ = new SparseArray<>();
    private SparseArray<Long> cWR = new SparseArray<>();
    private SparseArray<Long> cWS = new SparseArray<>();
    private SparseArray<Long> cWT = new SparseArray<>();

    private a() {
    }

    public static a aoY() {
        return cWO;
    }

    public long getCreateTime() {
        return this.cWP;
    }

    public void setCreateTime(long j) {
        this.cWP = j;
    }

    public long kN(int i) {
        Long l = this.cWR.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cWR.put(i, Long.valueOf(j));
    }

    public long kO(int i) {
        Long l = this.cWQ.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cWQ.put(i, Long.valueOf(j));
    }

    public long kP(int i) {
        Long l = this.cWS.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cWS.put(i, Long.valueOf(j));
    }

    public long kQ(int i) {
        Long l = this.cWT.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cWT.put(i, Long.valueOf(j));
    }
}
