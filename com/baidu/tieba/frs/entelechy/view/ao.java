package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ am bMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bMt = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bMt.KN() != null) {
            this.bMt.KN().a(view, this.bMt.abb);
        }
    }
}
