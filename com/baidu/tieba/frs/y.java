package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class y extends SparseArray<af> {
    public BdUniqueId cxx = null;

    public void a(ai aiVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                af valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(aiVar);
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
                af valueAt = valueAt(i2);
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
                af valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.aLx();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, af afVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, afVar);
    }

    public af rL(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
