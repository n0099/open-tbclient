package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r bBs;
    private View.OnTouchListener bBt;

    public r OG() {
        return this.bBs;
    }

    public View.OnTouchListener OH() {
        return this.bBt;
    }

    public void onDestroy() {
        if (this.bBs != null) {
            this.bBs.OF();
        }
    }
}
