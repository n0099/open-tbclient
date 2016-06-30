package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bi {
    private HashMap<String, Drawable> bEr = new HashMap<>();

    public Drawable o(int i, int i2) {
        String Y = Y(i, i2);
        Drawable drawable = this.bEr.get(Y);
        if (drawable == null) {
            Drawable o = com.baidu.tbadk.core.util.av.o(i2, i);
            this.bEr.put(Y, o);
            return o.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String Y(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bEr.isEmpty()) {
            this.bEr.clear();
        }
    }
}
