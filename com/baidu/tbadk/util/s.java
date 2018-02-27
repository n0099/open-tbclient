package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r bDj;
    private View.OnTouchListener bDk;

    public r Pk() {
        return this.bDj;
    }

    public View.OnTouchListener Pl() {
        return this.bDk;
    }

    public void onDestroy() {
        if (this.bDj != null) {
            this.bDj.Pj();
        }
    }
}
