package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, Drawable> gXK = new HashMap<>();

    public void destory() {
        if (!this.gXK.isEmpty()) {
            this.gXK.clear();
        }
    }
}
