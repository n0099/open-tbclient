package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.view.View;
/* loaded from: classes.dex */
public class a {
    private final View fAL;
    private boolean fAM;
    private View fAN;

    public a(View view) {
        this.fAL = view;
    }

    public void kQ(boolean z) {
        this.fAM = z;
        if (!z && this.fAL.getVisibility() == 4) {
            this.fAL.setVisibility(8);
        }
        if (!z && this.fAN != null) {
            bBp();
            this.fAN = null;
        }
    }

    private void bBp() {
        this.fAL.setVisibility(4);
        com.baidu.tbadk.editortools.noConflictPanel.b.b.bS(this.fAN);
    }
}
