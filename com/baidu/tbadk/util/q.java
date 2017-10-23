package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class q {
    private p aLL;
    private View.OnTouchListener aLM;

    public p GM() {
        return this.aLL;
    }

    public View.OnTouchListener GN() {
        return this.aLM;
    }

    public void onDestroy() {
        if (this.aLL != null) {
            this.aLL.GL();
        }
    }
}
