package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ac extends SparseArray<ak> {
    public BdUniqueId aSB = null;

    public void a(am amVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ak valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(amVar);
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
                ak valueAt = valueAt(i2);
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
                ak valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.QJ();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ak akVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, akVar);
    }

    public ak jW(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
