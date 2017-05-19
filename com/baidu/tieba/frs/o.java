package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    private HashMap<String, Drawable> bNP = new HashMap<>();

    public Drawable v(int i, int i2) {
        String ah = ah(i, i2);
        Drawable drawable = this.bNP.get(ah);
        if (drawable == null) {
            Drawable v = com.baidu.tbadk.core.util.aq.v(i2, i);
            this.bNP.put(ah, v);
            return v.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String ah(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bNP.isEmpty()) {
            this.bNP.clear();
        }
    }
}
