package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View fjj;
    private boolean fjk;
    private View fjl;

    public a(View view) {
        this.fjj = view;
    }

    public void jX(boolean z) {
        this.fjk = z;
        if (!z && this.fjj.getVisibility() == 4) {
            this.fjj.setVisibility(8);
        }
        if (!z && this.fjl != null) {
            bxy();
            this.fjl = null;
        }
    }

    private void bxy() {
        this.fjj.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bz(this.fjl);
    }
}
