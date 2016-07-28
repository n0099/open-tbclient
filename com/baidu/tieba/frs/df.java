package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class df extends SparseArray<dl> {
    public BdUniqueId aTm = null;

    public void a(dm dmVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                dl valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(dmVar);
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
                dl valueAt = valueAt(i2);
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
                dl valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Vk();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, dl dlVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, dlVar);
    }

    public dl ht(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
