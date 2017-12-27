package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, Drawable> dwi = new HashMap<>();

    public void destory() {
        if (!this.dwi.isEmpty()) {
            this.dwi.clear();
        }
    }
}
