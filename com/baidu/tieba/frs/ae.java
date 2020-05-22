package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ae {
    private static ae hqZ = new ae();
    private final SparseArray<String> hqY = new SparseArray<>();

    private ae() {
    }

    public static ae bWM() {
        return hqZ;
    }

    public void uf(int i) {
        this.hqY.put(i, "1");
    }

    public boolean ug(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hqY.get(i));
    }
}
