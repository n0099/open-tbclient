package com.baidu.tieba.frs.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.aGk = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aGk.Nv;
        if (bVar != null) {
            bVar2 = this.aGk.Nv;
            bVar2.pT();
        }
    }
}
