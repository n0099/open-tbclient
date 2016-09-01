package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class db extends SparseArray<dg> {
    public BdUniqueId aYu = null;

    public void a(dh dhVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                dg valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(dhVar);
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
                dg valueAt = valueAt(i2);
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
                dg valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.aaf();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, dg dgVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, dgVar);
    }

    public dg hW(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
