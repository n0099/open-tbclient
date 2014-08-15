package com.baidu.tieba.frs.view;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ FrsOfficalBanner a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsOfficalBanner frsOfficalBanner) {
        this.a = frsOfficalBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.c cVar;
        com.baidu.tbadk.coreExtra.view.c cVar2;
        cVar = this.a.e;
        if (cVar != null) {
            cVar2 = this.a.e;
            cVar2.a();
        }
    }
}
