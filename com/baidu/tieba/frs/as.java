package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class as {
    private HashMap<String, Drawable> bGV = new HashMap<>();

    public Drawable r(int i, int i2) {
        String aa = aa(i, i2);
        Drawable drawable = this.bGV.get(aa);
        if (drawable == null) {
            Drawable r = com.baidu.tbadk.core.util.ap.r(i2, i);
            this.bGV.put(aa, r);
            return r.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String aa(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bGV.isEmpty()) {
            this.bGV.clear();
        }
    }
}
