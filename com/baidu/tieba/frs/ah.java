package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes21.dex */
public class ah extends SparseArray<aq> {
    public BdUniqueId fzO = null;

    public void a(au auVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                aq valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(auVar);
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
                aq valueAt = valueAt(i2);
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
                aq valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.bYZ();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, aq aqVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, aqVar);
    }

    public aq Ai(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
