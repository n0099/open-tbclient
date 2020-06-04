package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ae {
    private static ae hrk = new ae();
    private final SparseArray<String> hrj = new SparseArray<>();

    private ae() {
    }

    public static ae bWO() {
        return hrk;
    }

    public void uh(int i) {
        this.hrj.put(i, "1");
    }

    public boolean ui(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hrj.get(i));
    }
}
