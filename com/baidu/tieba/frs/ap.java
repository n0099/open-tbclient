package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ap {
    private HashMap<String, Drawable> bTk = new HashMap<>();

    public Drawable q(int i, int i2) {
        String ag = ag(i, i2);
        Drawable drawable = this.bTk.get(ag);
        if (drawable == null) {
            Drawable q = com.baidu.tbadk.core.util.at.q(i2, i);
            this.bTk.put(ag, q);
            return q.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String ag(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bTk.isEmpty()) {
            this.bTk.clear();
        }
    }
}
