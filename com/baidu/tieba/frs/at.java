package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private HashMap<String, Drawable> bzv = new HashMap<>();

    public Drawable q(int i, int i2) {
        String ab = ab(i, i2);
        Drawable drawable = this.bzv.get(ab);
        if (drawable == null) {
            Drawable q = com.baidu.tbadk.core.util.ar.q(i2, i);
            this.bzv.put(ab, q);
            return q.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String ab(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bzv.isEmpty()) {
            this.bzv.clear();
        }
    }
}
