package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class i {
    private HashMap<String, Drawable> hSj = new HashMap<>();

    public void destory() {
        if (!this.hSj.isEmpty()) {
            this.hSj.clear();
        }
    }
}
