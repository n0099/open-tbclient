package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes15.dex */
public class ai extends SparseArray<ar> {
    public BdUniqueId ePz = null;

    public void a(av avVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ar valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(avVar);
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
                ar valueAt = valueAt(i2);
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
                ar valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.bLP();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ar arVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, arVar);
    }

    public ar xu(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
