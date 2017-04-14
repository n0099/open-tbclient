package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ as bTO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bTO = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bTO.getOnSubCardOnClickListenner() != null) {
            this.bTO.getOnSubCardOnClickListenner().a(view, this.bTO.aiB);
        }
    }
}
