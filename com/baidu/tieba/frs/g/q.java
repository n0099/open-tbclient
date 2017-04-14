package com.baidu.tieba.frs.g;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ i cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(i iVar) {
        this.cbv = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cbv.adO()) {
            return;
        }
        this.cbv.adK();
    }
}
