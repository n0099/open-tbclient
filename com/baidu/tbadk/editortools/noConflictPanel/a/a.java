package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View fDa;
    private boolean fDb;
    private View fDc;

    public a(View view) {
        this.fDa = view;
    }

    public void kT(boolean z) {
        this.fDb = z;
        if (!z && this.fDa.getVisibility() == 4) {
            this.fDa.setVisibility(8);
        }
        if (!z && this.fDc != null) {
            bBH();
            this.fDc = null;
        }
    }

    private void bBH() {
        this.fDa.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bO(this.fDc);
    }
}
