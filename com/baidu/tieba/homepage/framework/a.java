package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a cQY = new a();
    private long cQZ = 0;
    private SparseArray<Long> cRa = new SparseArray<>();
    private SparseArray<Long> cRb = new SparseArray<>();
    private SparseArray<Long> cRc = new SparseArray<>();
    private SparseArray<Long> cRd = new SparseArray<>();

    private a() {
    }

    public static a aod() {
        return cQY;
    }

    public long getCreateTime() {
        return this.cQZ;
    }

    public void setCreateTime(long j) {
        this.cQZ = j;
    }

    public long ks(int i) {
        Long l = this.cRb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.cRb.put(i, Long.valueOf(j));
    }

    public long kt(int i) {
        Long l = this.cRa.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cRa.put(i, Long.valueOf(j));
    }

    public long ku(int i) {
        Long l = this.cRc.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.cRc.put(i, Long.valueOf(j));
    }

    public long kv(int i) {
        Long l = this.cRd.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.cRd.put(i, Long.valueOf(j));
    }
}
