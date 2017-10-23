package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private HashMap<String, Drawable> cpJ = new HashMap<>();

    public Drawable u(int i, int i2) {
        String av = av(i, i2);
        Drawable drawable = this.cpJ.get(av);
        if (drawable == null) {
            Drawable u = com.baidu.tbadk.core.util.aj.u(i2, i);
            this.cpJ.put(av, u);
            return u.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String av(int i, int i2) {
        return i + "_" + i2;
    }

    public void destory() {
        if (!this.cpJ.isEmpty()) {
            this.cpJ.clear();
        }
    }
}
