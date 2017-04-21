package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ as bWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bWf = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bWf.getOnSubCardOnClickListenner() != null) {
            this.bWf.getOnSubCardOnClickListenner().a(view, this.bWf.aiC);
        }
    }
}
