package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class dc {
    private static dc bTv = new dc();
    private final SparseArray<String> bTu = new SparseArray<>();

    private dc() {
    }

    public static dc acm() {
        return bTv;
    }

    public void hX(int i) {
        this.bTu.put(i, "1");
    }

    public boolean hY(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bTu.get(i));
    }
}
