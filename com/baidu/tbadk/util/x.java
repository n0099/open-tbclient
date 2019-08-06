package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private w cDr;
    private View.OnTouchListener cmw;

    public w awy() {
        return this.cDr;
    }

    public View.OnTouchListener awz() {
        return this.cmw;
    }

    public void onDestroy() {
        if (this.cDr != null) {
            this.cDr.awx();
        }
    }
}
