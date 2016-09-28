package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m aZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aZq = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aZq.getOnSubCardOnClickListenner() != null) {
            this.aZq.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
