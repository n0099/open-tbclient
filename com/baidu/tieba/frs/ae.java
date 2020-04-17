package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ae {
    private static ae hcf = new ae();
    private final SparseArray<String> hce = new SparseArray<>();

    private ae() {
    }

    public static ae bQr() {
        return hcf;
    }

    public void tA(int i) {
        this.hce.put(i, "1");
    }

    public boolean tB(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hce.get(i));
    }
}
