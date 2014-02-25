package com.baidu.tieba.faceshop;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ FaceBuyWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.a = faceBuyWebViewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.closeActivity();
    }
}
