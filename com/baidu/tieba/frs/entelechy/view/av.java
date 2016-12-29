package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ as bGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bGD = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bGD.getOnSubCardOnClickListenner() != null) {
            this.bGD.getOnSubCardOnClickListenner().a(view, this.bGD.adN);
        }
    }
}
