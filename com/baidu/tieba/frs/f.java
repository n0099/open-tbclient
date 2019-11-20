package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, Drawable> ftW = new HashMap<>();

    public void destory() {
        if (!this.ftW.isEmpty()) {
            this.ftW.clear();
        }
    }
}
