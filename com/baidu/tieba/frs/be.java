package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class be {
    private HashMap<String, Drawable> bQJ = new HashMap<>();

    public Drawable q(int i, int i2) {
        String ae = ae(i, i2);
        Drawable drawable = this.bQJ.get(ae);
        if (drawable == null) {
            Drawable q = com.baidu.tbadk.core.util.av.q(i2, i);
            this.bQJ.put(ae, q);
            return q.getConstantState().newDrawable();
        }
        return drawable.getConstantState().newDrawable();
    }

    private String ae(int i, int i2) {
        return String.valueOf(i) + "_" + i2;
    }

    public void destory() {
        if (!this.bQJ.isEmpty()) {
            this.bQJ.clear();
        }
    }
}
