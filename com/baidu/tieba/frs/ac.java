package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ac extends SparseArray<ak> {
    public BdUniqueId bIv = null;

    public void a(an anVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ak valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(anVar);
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
                    valueAt.YZ();
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

    public ak mY(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
