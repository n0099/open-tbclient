package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnKeyListener {
    final /* synthetic */ k cdH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cdH = kVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cdH.ado();
            return true;
        }
        return false;
    }
}
