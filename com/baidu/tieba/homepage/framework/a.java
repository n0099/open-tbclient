package com.baidu.tieba.homepage.framework;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a coc = new a();
    private long cod = 0;
    private SparseArray<Long> coe = new SparseArray<>();
    private SparseArray<Long> cof = new SparseArray<>();
    private SparseArray<Long> cog = new SparseArray<>();
    private SparseArray<Long> coh = new SparseArray<>();

    private a() {
    }

    public static a agi() {
        return coc;
    }

    public long getCreateTime() {
        return this.cod;
    }

    public void setCreateTime(long j) {
        this.cod = j;
    }

    public long jh(int i) {
        Long l = this.cof.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void b(long j, int i) {
        this.cof.put(i, Long.valueOf(j));
    }

    public long ji(int i) {
        Long l = this.coe.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void c(long j, int i) {
        this.coe.put(i, Long.valueOf(j));
    }

    public long jj(int i) {
        Long l = this.cog.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void d(long j, int i) {
        this.cog.put(i, Long.valueOf(j));
    }

    public long jk(int i) {
        Long l = this.coh.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.coh.put(i, Long.valueOf(j));
    }
}
