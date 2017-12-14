package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private HashMap<String, Drawable> cGK = new HashMap<>();

    public Drawable v(int i, int i2) {
        String ax = ax(i, i2);
        Drawable drawable = this.cGK.get(ax);
        if (drawable == null) {
            Drawable v = com.baidu.tbadk.core.util.aj.v(i2, i);
            this.cGK.put(ax, v);
            return v.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String ax(int i, int i2) {
        return i + "_" + i2;
    }

    public void destory() {
        if (!this.cGK.isEmpty()) {
            this.cGK.clear();
        }
    }
}
