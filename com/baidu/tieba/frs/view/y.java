package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnKeyListener {
    final /* synthetic */ x bwN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bwN = xVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.bwN.Ur();
            return true;
        }
        return false;
    }
}
