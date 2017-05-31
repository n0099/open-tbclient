package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    private HashMap<String, Drawable> bTB = new HashMap<>();

    public Drawable u(int i, int i2) {
        String ah = ah(i, i2);
        Drawable drawable = this.bTB.get(ah);
        if (drawable == null) {
            Drawable u = com.baidu.tbadk.core.util.aq.u(i2, i);
            this.bTB.put(ah, u);
            return u.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String ah(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bTB.isEmpty()) {
            this.bTB.clear();
        }
    }
}
