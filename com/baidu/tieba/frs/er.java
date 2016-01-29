package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class er {
    private static er blA = new er();
    private final SparseArray<String> blz = new SparseArray<>();

    private er() {
    }

    public static er QA() {
        return blA;
    }

    public void gB(int i) {
        this.blz.put(i, "1");
    }

    public boolean gC(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.blz.get(i));
    }
}
