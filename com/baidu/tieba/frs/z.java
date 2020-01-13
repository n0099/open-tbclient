package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class z extends SparseArray<ag> {
    public BdUniqueId dxg = null;

    public void a(aj ajVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ag valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(ajVar);
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
                ag valueAt = valueAt(i2);
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
                ag valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.beK();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ag agVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, agVar);
    }

    public ag sT(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
