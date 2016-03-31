package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnKeyListener {
    final /* synthetic */ ac bxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.bxd = acVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.bxd.Ut();
            return true;
        }
        return false;
    }
}
