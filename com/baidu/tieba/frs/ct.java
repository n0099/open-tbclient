package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ct extends SparseArray<db> {
    public void a(dc dcVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                db valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(dcVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void init() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                db valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.init();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void destory() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                db valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.KL();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, db dbVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, dbVar);
    }

    public db ft(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
