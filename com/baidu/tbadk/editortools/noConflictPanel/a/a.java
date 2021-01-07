package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View fFt;
    private boolean fFu;
    private View fFv;

    public a(View view) {
        this.fFt = view;
    }

    public void kU(boolean z) {
        this.fFu = z;
        if (!z && this.fFt.getVisibility() == 4) {
            this.fFt.setVisibility(8);
        }
        if (!z && this.fFv != null) {
            bFj();
            this.fFv = null;
        }
    }

    private void bFj() {
        this.fFt.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bS(this.fFv);
    }
}
