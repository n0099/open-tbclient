package com.baidu.tieba.account;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new AlertDialog.Builder(this.a).setTitle(com.baidu.tieba.a.k.alerm_title).setIcon((Drawable) null).setCancelable(true).setItems(com.baidu.tieba.a.c.delete_account, new c(this, view)).create().show();
    }
}
