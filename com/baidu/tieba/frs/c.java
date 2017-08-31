package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private HashMap<String, Drawable> coE = new HashMap<>();

    public Drawable u(int i, int i2) {
        String am = am(i, i2);
        Drawable drawable = this.coE.get(am);
        if (drawable == null) {
            Drawable u = com.baidu.tbadk.core.util.aj.u(i2, i);
            this.coE.put(am, u);
            return u.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String am(int i, int i2) {
        return i + "_" + i2;
    }

    public void destory() {
        if (!this.coE.isEmpty()) {
            this.coE.clear();
        }
    }
}
