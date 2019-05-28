package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, Drawable> fop = new HashMap<>();

    public void destory() {
        if (!this.fop.isEmpty()) {
            this.fop.clear();
        }
    }
}
