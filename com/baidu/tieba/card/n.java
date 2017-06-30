package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bAY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bAY = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bAY.Vs() != null) {
            this.bAY.Vs().a(view, null);
        }
    }
}
