package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bls;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bls = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bls.getOnSubCardOnClickListenner() != null) {
            this.bls.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
