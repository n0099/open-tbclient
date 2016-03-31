package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bw {
    private HashMap<String, Drawable> bmW = new HashMap<>();

    public Drawable o(int i, int i2) {
        String T = T(i, i2);
        Drawable drawable = this.bmW.get(T);
        if (drawable == null) {
            Drawable o = com.baidu.tbadk.core.util.at.o(i2, i);
            this.bmW.put(T, o);
            return o.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String T(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bmW.isEmpty()) {
            this.bmW.clear();
        }
    }
}
