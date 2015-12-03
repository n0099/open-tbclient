package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class eg {
    private static eg beL = new eg();
    private final SparseArray<String> beK = new SparseArray<>();

    private eg() {
    }

    public static eg Of() {
        return beL;
    }

    public void gl(int i) {
        this.beK.put(i, "1");
    }

    public boolean gm(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.beK.get(i));
    }
}
