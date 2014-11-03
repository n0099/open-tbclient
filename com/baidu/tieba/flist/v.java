package com.baidu.tieba.flist;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnKeyListener {
    final /* synthetic */ u awQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.awQ = uVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && this.awQ.awI.isShowing()) {
            com.baidu.adp.lib.g.j.a(this.awQ.awI, this.awQ.awK);
            return false;
        }
        return false;
    }
}
