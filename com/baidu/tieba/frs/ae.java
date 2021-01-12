package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ae extends SparseArray<an> {
    public BdUniqueId fEN = null;

    public void a(ar arVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                an valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(arVar);
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
                an valueAt = valueAt(i2);
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
                an valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.bXP();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, an anVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, anVar);
    }

    public an yO(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
