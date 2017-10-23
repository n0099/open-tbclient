package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ab extends SparseArray<aj> {
    public BdUniqueId aPk = null;

    public void a(al alVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                aj valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(alVar);
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
                aj valueAt = valueAt(i2);
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
                aj valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Pf();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, aj ajVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, ajVar);
    }

    public aj jh(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
