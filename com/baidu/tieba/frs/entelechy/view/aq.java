package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ ao caW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.caW = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.caW.getOnSubCardOnClickListenner() != null) {
            this.caW.getOnSubCardOnClickListenner().a(view, this.caW.aeu);
        }
    }
}
