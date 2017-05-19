package com.baidu.tieba.frs.e;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(i iVar) {
        this.cbx = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cbx.acR()) {
            return;
        }
        this.cbx.acN();
    }
}
