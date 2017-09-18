package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private HashMap<String, Drawable> cpw = new HashMap<>();

    public Drawable u(int i, int i2) {
        String aq = aq(i, i2);
        Drawable drawable = this.cpw.get(aq);
        if (drawable == null) {
            Drawable u = com.baidu.tbadk.core.util.aj.u(i2, i);
            this.cpw.put(aq, u);
            return u.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String aq(int i, int i2) {
        return i + "_" + i2;
    }

    public void destory() {
        if (!this.cpw.isEmpty()) {
            this.cpw.clear();
        }
    }
}
