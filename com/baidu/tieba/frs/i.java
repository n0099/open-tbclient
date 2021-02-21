package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i {
    private HashMap<String, Drawable> jfQ = new HashMap<>();

    public void destory() {
        if (!this.jfQ.isEmpty()) {
            this.jfQ.clear();
        }
    }
}
