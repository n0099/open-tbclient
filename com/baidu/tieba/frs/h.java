package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private HashMap<String, Drawable> hze = new HashMap<>();

    public void destory() {
        if (!this.hze.isEmpty()) {
            this.hze.clear();
        }
    }
}
