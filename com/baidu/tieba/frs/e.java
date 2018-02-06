package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, Drawable> dDX = new HashMap<>();

    public void destory() {
        if (!this.dDX.isEmpty()) {
            this.dDX.clear();
        }
    }
}
