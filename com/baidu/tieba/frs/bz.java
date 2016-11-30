package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bz extends SparseArray<ce> {
    public BdUniqueId bcf = null;

    public void a(cf cfVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ce valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(cfVar);
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
                ce valueAt = valueAt(i2);
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
                ce valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.abv();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ce ceVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, ceVar);
    }

    public ce hZ(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
