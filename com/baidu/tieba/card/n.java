package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bsd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bsd = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bsd.getOnSubCardOnClickListenner() != null) {
            this.bsd.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
