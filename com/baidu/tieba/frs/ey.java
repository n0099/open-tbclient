package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ey extends SparseArray<fo> {
    public void a(fp fpVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                fo valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(fpVar);
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
                fo valueAt = valueAt(i2);
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
                fo valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.Qe();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, fo foVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, foVar);
    }

    public fo gS(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
