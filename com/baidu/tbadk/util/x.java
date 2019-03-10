package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private View.OnTouchListener ccU;
    private w ctJ;

    public w aqm() {
        return this.ctJ;
    }

    public View.OnTouchListener aqn() {
        return this.ccU;
    }

    public void onDestroy() {
        if (this.ctJ != null) {
            this.ctJ.aql();
        }
    }
}
