package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bi {
    private HashMap<String, Drawable> bFB = new HashMap<>();

    public Drawable o(int i, int i2) {
        String Z = Z(i, i2);
        Drawable drawable = this.bFB.get(Z);
        if (drawable == null) {
            Drawable o = com.baidu.tbadk.core.util.av.o(i2, i);
            this.bFB.put(Z, o);
            return o.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String Z(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bFB.isEmpty()) {
            this.bFB.clear();
        }
    }
}
