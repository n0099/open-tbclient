package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ af aTi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.aTi = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aTi.Ld() != null) {
            this.aTi.Ld().a(view, null);
        }
    }
}
