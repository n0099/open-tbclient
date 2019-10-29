package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class w {
    private View.OnTouchListener cAp;
    private v cPo;

    public v axN() {
        return this.cPo;
    }

    public View.OnTouchListener axO() {
        return this.cAp;
    }

    public void onDestroy() {
        if (this.cPo != null) {
            this.cPo.axM();
        }
    }
}
