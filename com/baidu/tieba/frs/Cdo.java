package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* renamed from: com.baidu.tieba.frs.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo {
    private static Cdo aYp = new Cdo();
    private final SparseArray<String> aYo = new SparseArray<>();

    private Cdo() {
    }

    public static Cdo Mw() {
        return aYp;
    }

    public void fH(int i) {
        this.aYo.put(i, "1");
    }

    public boolean fI(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.aYo.get(i));
    }
}
