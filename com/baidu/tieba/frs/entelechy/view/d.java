package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bLV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        be beVar2;
        beVar = this.bLV.abb;
        if (beVar != null && this.bLV.KN() != null) {
            bx<be> KN = this.bLV.KN();
            beVar2 = this.bLV.abb;
            KN.a(view, beVar2);
        }
    }
}
