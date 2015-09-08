package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class cz extends SparseArray<dh> {
    public void a(di diVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                dh valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(diVar);
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
                dh valueAt = valueAt(i2);
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
                dh valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Kz();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, dh dhVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, dhVar);
    }

    public dh fB(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
