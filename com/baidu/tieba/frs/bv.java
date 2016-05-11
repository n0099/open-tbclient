package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bv {
    private HashMap<String, Drawable> biv = new HashMap<>();

    public Drawable o(int i, int i2) {
        String U = U(i, i2);
        Drawable drawable = this.biv.get(U);
        if (drawable == null) {
            Drawable o = com.baidu.tbadk.core.util.at.o(i2, i);
            this.biv.put(U, o);
            return o.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String U(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.biv.isEmpty()) {
            this.biv.clear();
        }
    }
}
