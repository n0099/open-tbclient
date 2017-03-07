package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ as bUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bUa = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUa.getOnSubCardOnClickListenner() != null) {
            this.bUa.getOnSubCardOnClickListenner().a(view, this.bUa.ain);
        }
    }
}
