package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class be {
    private HashMap<String, Drawable> bQC = new HashMap<>();

    public Drawable q(int i, int i2) {
        String af = af(i, i2);
        Drawable drawable = this.bQC.get(af);
        if (drawable == null) {
            Drawable q = com.baidu.tbadk.core.util.av.q(i2, i);
            this.bQC.put(af, q);
            return q.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String af(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bQC.isEmpty()) {
            this.bQC.clear();
        }
    }
}
