package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class ad extends SparseArray<ak> {
    public BdUniqueId epM = null;

    public void a(ao aoVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ak valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(aoVar);
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
                    valueAt.bwk();
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

    public ak ug(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
