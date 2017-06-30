package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ as cig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.cig = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cig.Vs() != null) {
            this.cig.Vs().a(view, this.cig.aiu);
        }
    }
}
