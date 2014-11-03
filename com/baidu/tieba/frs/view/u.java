package com.baidu.tieba.frs.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.aGu = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aGu.Nz;
        if (bVar != null) {
            bVar2 = this.aGu.Nz;
            bVar2.pV();
        }
    }
}
