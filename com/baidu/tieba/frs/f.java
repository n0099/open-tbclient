package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, Drawable> foo = new HashMap<>();

    public void destory() {
        if (!this.foo.isEmpty()) {
            this.foo.clear();
        }
    }
}
