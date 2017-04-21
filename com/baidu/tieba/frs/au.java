package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class au {
    private HashMap<String, Drawable> bQk = new HashMap<>();

    public Drawable x(int i, int i2) {
        String ag = ag(i, i2);
        Drawable drawable = this.bQk.get(ag);
        if (drawable == null) {
            Drawable x = com.baidu.tbadk.core.util.aq.x(i2, i);
            this.bQk.put(ag, x);
            return x.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String ag(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bQk.isEmpty()) {
            this.bQk.clear();
        }
    }
}
