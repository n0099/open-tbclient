package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class dn extends SparseArray<ea> {
    public void a(eb ebVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                ea valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(ebVar);
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
                ea valueAt = valueAt(i2);
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
                ea valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Ku();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ea eaVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, eaVar);
    }

    public ea fG(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
