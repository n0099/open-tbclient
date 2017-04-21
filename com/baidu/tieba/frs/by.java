package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class by extends SparseArray<cd> {
    public BdUniqueId bbE = null;

    public void a(ce ceVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                cd valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(ceVar);
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
                cd valueAt = valueAt(i2);
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
                cd valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Nx();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, cd cdVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, cdVar);
    }

    public cd ib(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
