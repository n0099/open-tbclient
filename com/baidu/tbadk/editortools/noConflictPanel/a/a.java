package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View faK;
    private boolean faL;
    private View faM;

    public a(View view) {
        this.faK = view;
    }

    public void jK(boolean z) {
        this.faL = z;
        if (!z && this.faK.getVisibility() == 4) {
            this.faK.setVisibility(8);
        }
        if (!z && this.faM != null) {
            bvF();
            this.faM = null;
        }
    }

    private void bvF() {
        this.faK.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.by(this.faM);
    }
}
