package com.baidu.tieba.frs.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o aRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aRA = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aRA.afa;
        if (bVar != null) {
            bVar2 = this.aRA.afa;
            bVar2.xJ();
        }
    }
}
