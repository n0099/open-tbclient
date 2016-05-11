package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ep extends SparseArray<fg> {
    public BdUniqueId aOT = null;

    public void a(fi fiVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                fg valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(fiVar);
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
                fg valueAt = valueAt(i2);
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
                fg valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.OY();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, fg fgVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, fgVar);
    }

    public fg gu(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
