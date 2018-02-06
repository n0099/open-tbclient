package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r bDw;
    private View.OnTouchListener bDx;

    public r Pl() {
        return this.bDw;
    }

    public View.OnTouchListener Pm() {
        return this.bDx;
    }

    public void onDestroy() {
        if (this.bDw != null) {
            this.bDw.Pk();
        }
    }
}
