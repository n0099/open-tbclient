package com.baidu.tieba.frs.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ o aJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.aJb = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aJb.TP;
        if (bVar != null) {
            bVar2 = this.aJb.TP;
            bVar2.tE();
        }
    }
}
