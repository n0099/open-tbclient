package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnKeyListener {
    final /* synthetic */ q cfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cfU = qVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cfU.aeK();
            return true;
        }
        return false;
    }
}
