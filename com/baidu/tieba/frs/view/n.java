package com.baidu.tieba.frs.view;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsOfficalBanner aFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsOfficalBanner frsOfficalBanner) {
        this.aFY = frsOfficalBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aFY.Nv;
        if (bVar != null) {
            bVar2 = this.aFY.Nv;
            bVar2.pT();
        }
    }
}
