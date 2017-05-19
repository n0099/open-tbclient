package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ i bur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bur = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bur.getOnSubCardOnClickListenner() != null) {
            this.bur.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
