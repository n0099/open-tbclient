package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnKeyListener {
    final /* synthetic */ p bWt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bWt = pVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.bWt.abi();
            return true;
        }
        return false;
    }
}
