package com.baidu.tieba.frs.view;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsOfficalBanner aGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsOfficalBanner frsOfficalBanner) {
        this.aGi = frsOfficalBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aGi.Nz;
        if (bVar != null) {
            bVar2 = this.aGi.Nz;
            bVar2.pV();
        }
    }
}
