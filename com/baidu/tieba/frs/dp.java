package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class dp extends SparseArray<ec> {
    public void a(ed edVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ec valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(edVar);
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
                ec valueAt = valueAt(i2);
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
                ec valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.KG();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ec ecVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, ecVar);
    }

    public ec fO(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
