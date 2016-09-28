package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnKeyListener {
    final /* synthetic */ p chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.chB = pVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.chB.agh();
            return true;
        }
        return false;
    }
}
