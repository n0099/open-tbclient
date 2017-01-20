package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bMu = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bhVar = this.bMu.acX;
        if (bhVar != null && this.bMu.getOnSubCardOnClickListenner() != null) {
            cf<bh> onSubCardOnClickListenner = this.bMu.getOnSubCardOnClickListenner();
            bhVar2 = this.bMu.acX;
            onSubCardOnClickListenner.a(view, bhVar2);
        }
    }
}
