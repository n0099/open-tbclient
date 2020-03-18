package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class aa extends SparseArray<ah> {
    public BdUniqueId dBK = null;

    public void a(ak akVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ah valueAt = valueAt(i2);
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
                ah valueAt = valueAt(i2);
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
                ah valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.bhc();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ah ahVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, ahVar);
    }

    public ah tb(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
