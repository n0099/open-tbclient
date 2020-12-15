package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i {
    private HashMap<String, Drawable> iSr = new HashMap<>();

    public void destory() {
        if (!this.iSr.isEmpty()) {
            this.iSr.clear();
        }
    }
}
