package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class br extends SparseArray<bx> {
    public BdUniqueId aLk = null;

    public void a(by byVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                bx valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(byVar);
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
                bx valueAt = valueAt(i2);
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
                bx valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.ML();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, bx bxVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, bxVar);
    }

    public bx hR(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
