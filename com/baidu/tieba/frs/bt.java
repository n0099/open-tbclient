package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bt extends SparseArray<bz> {
    public BdUniqueId aMp = null;

    public void a(ca caVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                bz valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(caVar);
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
                bz valueAt = valueAt(i2);
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
                bz valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Og();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, bz bzVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, bzVar);
    }

    public bz iB(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
