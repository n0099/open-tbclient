package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fyd = new z();
    private final SparseArray<String> fyc = new SparseArray<>();

    private z() {
    }

    public static z bnO() {
        return fyd;
    }

    public void rO(int i) {
        this.fyc.put(i, "1");
    }

    public boolean rP(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fyc.get(i));
    }
}
