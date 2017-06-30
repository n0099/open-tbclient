package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ c bAC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bAC = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bAC.Vs() != null) {
            this.bAC.Vs().a(view, this.bAC.bAA);
        }
    }
}
