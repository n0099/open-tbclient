package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r aNJ;
    private View.OnTouchListener aNK;

    public r HN() {
        return this.aNJ;
    }

    public View.OnTouchListener HO() {
        return this.aNK;
    }

    public void onDestroy() {
        if (this.aNJ != null) {
            this.aNJ.HM();
        }
    }
}
