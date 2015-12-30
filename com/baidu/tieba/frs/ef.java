package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ef extends SparseArray<eu> {
    public void a(ev evVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                eu valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(evVar);
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
                eu valueAt = valueAt(i2);
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
                eu valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.a(null);
                    valueAt.My();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, eu euVar) {
        if (i > 100) {
            i = 100;
        }
        put(i, euVar);
    }

    public eu gd(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }
}
