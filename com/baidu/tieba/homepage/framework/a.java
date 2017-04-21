package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cvZ = new a();
    private long cwa = 0;
    private SparseArray<Long> cwb = new SparseArray<>();
    private SparseArray<Long> cwc = new SparseArray<>();
    private SparseArray<Long> cwd = new SparseArray<>();
    private SparseArray<Long> cwe = new SparseArray<>();

    private a() {
    }

    public static a aju() {
        return cvZ;
    }

    public long getCreateTime() {
        return this.cwa;
    }

    public void setCreateTime(long j) {
        this.cwa = j;
    }

    public long jH(int i) {
        Long l = this.cwc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cwc.put(i, Long.valueOf(j));
    }

    public long jI(int i) {
        Long l = this.cwb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cwb.put(i, Long.valueOf(j));
    }

    public long jJ(int i) {
        Long l = this.cwd.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cwd.put(i, Long.valueOf(j));
    }

    public long jK(int i) {
        Long l = this.cwe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cwe.put(i, Long.valueOf(j));
    }
}
