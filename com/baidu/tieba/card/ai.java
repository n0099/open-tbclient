package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ ah aOK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.aOK = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.p pVar;
        com.baidu.tieba.card.a.p pVar2;
        pVar = this.aOK.aOJ;
        if (pVar != null) {
            pVar2 = this.aOK.aOJ;
            TiebaStatic.log(pVar2.ID());
        }
    }
}
