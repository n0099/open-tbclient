package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aa extends SparseArray<ai> {
    public BdUniqueId aNy = null;

    public void a(ak akVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ai valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(akVar);
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
                ai valueAt = valueAt(i2);
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
                ai valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Os();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ai aiVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, aiVar);
    }

    public ai iK(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
