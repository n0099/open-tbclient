package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bu {
    private HashMap<String, Drawable> bil = new HashMap<>();

    public Drawable s(int i, int i2) {
        String V = V(i, i2);
        Drawable drawable = this.bil.get(V);
        if (drawable == null) {
            Drawable s = com.baidu.tbadk.core.util.ar.s(i2, i);
            this.bil.put(V, s);
            return s.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String V(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bil.isEmpty()) {
            this.bil.clear();
        }
    }
}
