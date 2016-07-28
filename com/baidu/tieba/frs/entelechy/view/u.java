package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r bLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.bLX = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        if (this.bLX.KN() != null) {
            bx<be> KN = this.bLX.KN();
            beVar = this.bLX.abb;
            KN.a(view, beVar);
        }
    }
}
