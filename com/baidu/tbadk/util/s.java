package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r bDm;
    private View.OnTouchListener bDn;

    public r Pl() {
        return this.bDm;
    }

    public View.OnTouchListener Pm() {
        return this.bDn;
    }

    public void onDestroy() {
        if (this.bDm != null) {
            this.bDm.Pk();
        }
    }
}
