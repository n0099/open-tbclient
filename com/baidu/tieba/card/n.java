package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m buv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.buv = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.buv.getOnSubCardOnClickListenner() != null) {
            this.buv.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
