package com.baidu.tieba.frs.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o aOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aOZ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aOZ.adO;
        if (bVar != null) {
            bVar2 = this.aOZ.adO;
            bVar2.wR();
        }
    }
}
