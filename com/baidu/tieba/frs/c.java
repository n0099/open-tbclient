package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private HashMap<String, Drawable> cxd = new HashMap<>();

    public Drawable u(int i, int i2) {
        String aw = aw(i, i2);
        Drawable drawable = this.cxd.get(aw);
        if (drawable == null) {
            Drawable u = com.baidu.tbadk.core.util.aj.u(i2, i);
            this.cxd.put(aw, u);
            return u.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String aw(int i, int i2) {
        return i + "_" + i2;
    }

    public void destory() {
        if (!this.cxd.isEmpty()) {
            this.cxd.clear();
        }
    }
}
