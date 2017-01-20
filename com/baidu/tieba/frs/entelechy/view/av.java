package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ as bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bMS = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bMS.getOnSubCardOnClickListenner() != null) {
            this.bMS.getOnSubCardOnClickListenner().a(view, this.bMS.acX);
        }
    }
}
