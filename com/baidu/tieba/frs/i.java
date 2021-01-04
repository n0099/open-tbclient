package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i {
    private HashMap<String, Drawable> jeD = new HashMap<>();

    public void destory() {
        if (!this.jeD.isEmpty()) {
            this.jeD.clear();
        }
    }
}
