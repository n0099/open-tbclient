package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View fvN;
    private boolean fvO;
    private View fvP;

    public a(View view) {
        this.fvN = view;
    }

    public void ky(boolean z) {
        this.fvO = z;
        if (!z && this.fvN.getVisibility() == 4) {
            this.fvN.setVisibility(8);
        }
        if (!z && this.fvP != null) {
            bCN();
            this.fvP = null;
        }
    }

    private void bCN() {
        this.fvN.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bJ(this.fvP);
    }
}
