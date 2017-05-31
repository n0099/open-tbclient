package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ as bZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.bZW = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bZW.Ud() != null) {
            this.bZW.Ud().a(view, this.bZW.ahM);
        }
    }
}
