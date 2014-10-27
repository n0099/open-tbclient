package com.baidu.tieba.faceshop;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ FaceBuyWebViewActivity asZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.asZ = faceBuyWebViewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
