package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r bBb;
    private View.OnTouchListener bBc;

    public r OQ() {
        return this.bBb;
    }

    public View.OnTouchListener OR() {
        return this.bBc;
    }

    public void onDestroy() {
        if (this.bBb != null) {
            this.bBb.OP();
        }
    }
}
