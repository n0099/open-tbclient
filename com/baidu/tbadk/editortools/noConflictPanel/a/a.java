package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View eOD;
    private boolean eOE;
    private View eOF;

    public a(View view) {
        this.eOD = view;
    }

    public void jm(boolean z) {
        this.eOE = z;
        if (!z && this.eOD.getVisibility() == 4) {
            this.eOD.setVisibility(8);
        }
        if (!z && this.eOF != null) {
            bsV();
            this.eOF = null;
        }
    }

    private void bsV() {
        this.eOD.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bu(this.eOF);
    }
}
