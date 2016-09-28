package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap bXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.bXH = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bXH.getOnSubCardOnClickListenner() != null) {
            this.bXH.getOnSubCardOnClickListenner().a(view, this.bXH.adW);
        }
    }
}
