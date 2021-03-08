package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private boolean fEA;
    private View fEB;
    private final View fEz;

    public a(View view) {
        this.fEz = view;
    }

    public void kT(boolean z) {
        this.fEA = z;
        if (!z && this.fEz.getVisibility() == 4) {
            this.fEz.setVisibility(8);
        }
        if (!z && this.fEB != null) {
            bBK();
            this.fEB = null;
        }
    }

    private void bBK() {
        this.fEz.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bO(this.fEB);
    }
}
