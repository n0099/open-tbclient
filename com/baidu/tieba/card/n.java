package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bsl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bsl = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bsl.getOnSubCardOnClickListenner() != null) {
            this.bsl.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
