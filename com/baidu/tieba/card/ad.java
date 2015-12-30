package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ y aOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar) {
        this.aOv = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        nVar = this.aOv.aOj;
        if (nVar != null) {
            nVar2 = this.aOv.aOj;
            TiebaStatic.log(nVar2.IC());
        }
    }
}
