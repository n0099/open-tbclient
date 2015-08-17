package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class cu {
    private static cu aYx = new cu();
    private final SparseArray<String> aYw = new SparseArray<>();

    private cu() {
    }

    public static cu My() {
        return aYx;
    }

    public void fu(int i) {
        this.aYw.put(i, "1");
    }

    public boolean fv(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.aYw.get(i));
    }
}
