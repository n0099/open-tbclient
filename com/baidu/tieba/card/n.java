package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bAf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bAf = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bAf.Ud() != null) {
            this.bAf.Ud().a(view, null);
        }
    }
}
