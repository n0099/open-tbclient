package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private HashMap<String, Drawable> cXO = new HashMap<>();

    public void destory() {
        if (!this.cXO.isEmpty()) {
            this.cXO.clear();
        }
    }
}
