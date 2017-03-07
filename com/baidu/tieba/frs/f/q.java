package com.baidu.tieba.frs.f;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(i iVar) {
        this.ccU = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccU.adT()) {
            return;
        }
        this.ccU.adP();
    }
}
