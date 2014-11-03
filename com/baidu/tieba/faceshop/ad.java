package com.baidu.tieba.faceshop;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ FaceBuyWebViewActivity ati;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.ati = faceBuyWebViewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
