package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnKeyListener {
    final /* synthetic */ k cjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cjV = kVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cjV.aer();
            return true;
        }
        return false;
    }
}
