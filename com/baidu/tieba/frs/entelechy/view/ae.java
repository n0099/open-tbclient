package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad bKw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bKw = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.aj ajVar;
        if (this.bKw.KO() != null) {
            bx<com.baidu.tbadk.core.data.aj> KO = this.bKw.KO();
            ajVar = this.bKw.bKu;
            KO.a(view, ajVar);
        }
    }
}
