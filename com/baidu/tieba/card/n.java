package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bcz = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bcz.getOnSubCardOnClickListenner() != null) {
            this.bcz.getOnSubCardOnClickListenner().a(view, null);
        }
    }
}
