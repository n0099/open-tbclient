package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private HashMap<String, Drawable> cjj = new HashMap<>();

    public Drawable v(int i, int i2) {
        String an = an(i, i2);
        Drawable drawable = this.cjj.get(an);
        if (drawable == null) {
            Drawable v = com.baidu.tbadk.core.util.ai.v(i2, i);
            this.cjj.put(an, v);
            return v.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String an(int i, int i2) {
        return i + "_" + i2;
    }

    public void destory() {
        if (!this.cjj.isEmpty()) {
            this.cjj.clear();
        }
    }
}
