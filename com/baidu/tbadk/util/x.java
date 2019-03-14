package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private View.OnTouchListener ccU;
    private w ctG;

    public w aql() {
        return this.ctG;
    }

    public View.OnTouchListener aqm() {
        return this.ccU;
    }

    public void onDestroy() {
        if (this.ctG != null) {
            this.ctG.aqk();
        }
    }
}
