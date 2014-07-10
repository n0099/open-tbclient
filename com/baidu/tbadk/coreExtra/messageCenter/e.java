package com.baidu.tbadk.coreExtra.messageCenter;

import android.util.SparseArray;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class e {
    private static e a = null;
    private SparseArray<Long> b = new SparseArray<>();

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public void a(int i, long j) {
        synchronized (this.b) {
            Long l = this.b.get(i);
            if (l == null || l.longValue() <= j) {
                this.b.put(i, Long.valueOf(j));
            }
        }
    }

    public void b(int i, long j) {
        synchronized (this.b) {
            Long l = this.b.get(i);
            if (l == null || l.longValue() == 0) {
                this.b.put(i, Long.valueOf(j));
            }
        }
    }

    public synchronized void a(int i) {
        synchronized (this.b) {
            this.b.remove(i);
        }
    }

    public boolean b(int i) {
        return this.b.get(i) != null;
    }

    public synchronized void b() {
        synchronized (this.b) {
            this.b.clear();
        }
    }

    public long c(int i) {
        Long l = this.b.get(i);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public SparseArray<Long> c() {
        if (!TbadkApplication.isLogin()) {
            this.b.remove(10);
        }
        return this.b;
    }

    public long d() {
        long longValue;
        long j = 0;
        int size = this.b.size();
        int i = 0;
        while (i < size) {
            Long valueAt = this.b.valueAt(i);
            if (valueAt == null) {
                longValue = j;
            } else {
                longValue = valueAt.longValue();
                if (longValue <= j) {
                    longValue = j;
                }
            }
            i++;
            j = longValue;
        }
        return j;
    }
}
