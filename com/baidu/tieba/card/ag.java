package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ ae aOA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.aOA = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        oVar = this.aOA.aOw;
        TiebaStatic.log(oVar.IJ());
    }
}
