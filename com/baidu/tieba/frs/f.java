package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, Drawable> ftN = new HashMap<>();

    public void destory() {
        if (!this.ftN.isEmpty()) {
            this.ftN.clear();
        }
    }
}
