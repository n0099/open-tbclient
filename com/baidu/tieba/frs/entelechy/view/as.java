package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap bXM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.bXM = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bXM.getOnSubCardOnClickListenner() != null) {
            this.bXM.getOnSubCardOnClickListenner().a(view, this.bXM.adL);
        }
    }
}
