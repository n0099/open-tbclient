package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class af {
    private static af jjM = new af();
    private final SparseArray<String> jjL = new SparseArray<>();

    private af() {
    }

    public static af cHe() {
        return jjM;
    }

    public void Av(int i) {
        this.jjL.put(i, "1");
    }

    public boolean Aw(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.jjL.get(i));
    }
}
