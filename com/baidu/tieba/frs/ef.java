package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ef extends SparseArray<et> {
    public void a(eu euVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                et valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(euVar);
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
                et valueAt = valueAt(i2);
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
                et valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Mf();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, et etVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, etVar);
    }

    public et gk(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
