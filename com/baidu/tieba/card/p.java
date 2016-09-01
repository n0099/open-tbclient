package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ o aYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aYW = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aYW.getOnSubCardOnClickListenner() != null) {
            this.aYW.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
