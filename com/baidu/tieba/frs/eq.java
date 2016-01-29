package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class eq extends SparseArray<fe> {
    public void a(ff ffVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                fe valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(ffVar);
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
                fe valueAt = valueAt(i2);
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
                fe valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Op();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, fe feVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, feVar);
    }

    public fe gA(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
