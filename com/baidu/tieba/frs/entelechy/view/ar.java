package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ao bUc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.bUc = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUc.getOnSubCardOnClickListenner() != null) {
            this.bUc.getOnSubCardOnClickListenner().a(view, this.bUc.ahV);
        }
    }
}
