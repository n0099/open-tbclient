package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bw extends SparseArray<cb> {
    public BdUniqueId aUC = null;

    public void a(cc ccVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                cb valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(ccVar);
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
                cb valueAt = valueAt(i2);
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
                cb valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Me();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, cb cbVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, cbVar);
    }

    public cb hW(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
