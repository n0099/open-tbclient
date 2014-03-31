package com.baidu.tbadk.coreExtra.messageCenter;

import android.util.SparseArray;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class d {
    private static d a = null;
    private SparseArray<Long> b = new SparseArray<>();

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    public final void a(int i, long j) {
        synchronized (this.b) {
            Long l = this.b.get(i);
            if (l == null || l.longValue() <= j) {
                this.b.put(i, Long.valueOf(j));
            }
        }
    }

    public final void b(int i, long j) {
        synchronized (this.b) {
            Long l = this.b.get(i);
            if (l == null || l.longValue() == 0) {
                this.b.put(i, Long.valueOf(j));
            }
        }
    }

    public final synchronized void a(int i) {
        synchronized (this.b) {
            this.b.remove(i);
        }
    }

    public final SparseArray<Long> b() {
        if (!TbadkApplication.F()) {
            this.b.remove(10);
        }
        return this.b;
    }
}
