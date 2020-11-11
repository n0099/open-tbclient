package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View fpa;
    private boolean fpb;
    private View fpc;

    public a(View view) {
        this.fpa = view;
    }

    public void kg(boolean z) {
        this.fpb = z;
        if (!z && this.fpa.getVisibility() == 4) {
            this.fpa.setVisibility(8);
        }
        if (!z && this.fpc != null) {
            bzX();
            this.fpc = null;
        }
    }

    private void bzX() {
        this.fpa.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bD(this.fpc);
    }
}
