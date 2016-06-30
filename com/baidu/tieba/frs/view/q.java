package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnKeyListener {
    final /* synthetic */ p bUt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bUt = pVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.bUt.aaG();
            return true;
        }
        return false;
    }
}
