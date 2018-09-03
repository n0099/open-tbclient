package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r aWE;
    private View.OnTouchListener aWF;

    public r Ly() {
        return this.aWE;
    }

    public View.OnTouchListener Lz() {
        return this.aWF;
    }

    public void onDestroy() {
        if (this.aWE != null) {
            this.aWE.Lx();
        }
    }
}
