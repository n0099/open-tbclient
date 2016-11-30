package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ s caz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.caz = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        if (this.caz.getOnSubCardOnClickListenner() != null) {
            bz<bk> onSubCardOnClickListenner = this.caz.getOnSubCardOnClickListenner();
            bkVar = this.caz.aeu;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
