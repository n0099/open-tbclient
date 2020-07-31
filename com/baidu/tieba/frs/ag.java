package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes15.dex */
public class ag extends SparseArray<ap> {
    public BdUniqueId eEU = null;

    public void a(at atVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ap valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(atVar);
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
                ap valueAt = valueAt(i2);
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
                ap valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.bCu();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ap apVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, apVar);
    }

    public ap vd(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
