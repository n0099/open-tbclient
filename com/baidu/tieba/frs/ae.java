package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ae {
    private static ae hcl = new ae();
    private final SparseArray<String> hck = new SparseArray<>();

    private ae() {
    }

    public static ae bQp() {
        return hcl;
    }

    public void tA(int i) {
        this.hck.put(i, "1");
    }

    public boolean tB(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hck.get(i));
    }
}
