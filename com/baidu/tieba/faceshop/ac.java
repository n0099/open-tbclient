package com.baidu.tieba.faceshop;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ FaceBuyWebViewActivity asZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.asZ = faceBuyWebViewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.asZ.closeActivity();
    }
}
