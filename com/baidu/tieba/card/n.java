package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bbF = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbF.getOnSubCardOnClickListenner() != null) {
            this.bbF.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
