package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bs extends SparseArray<by> {
    public BdUniqueId aKZ = null;

    public void a(bz bzVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                by valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(bzVar);
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
                by valueAt = valueAt(i2);
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
                by valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.MT();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, by byVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, byVar);
    }

    public by ip(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
