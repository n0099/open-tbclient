package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i {
    private HashMap<String, Drawable> iAM = new HashMap<>();

    public void destory() {
        if (!this.iAM.isEmpty()) {
            this.iAM.clear();
        }
    }
}
