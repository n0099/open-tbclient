package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    private HashMap<String, Drawable> cbJ = new HashMap<>();

    public Drawable u(int i, int i2) {
        String an = an(i, i2);
        Drawable drawable = this.cbJ.get(an);
        if (drawable == null) {
            Drawable u = com.baidu.tbadk.core.util.as.u(i2, i);
            this.cbJ.put(an, u);
            return u.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String an(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.cbJ.isEmpty()) {
            this.cbJ.clear();
        }
    }
}
