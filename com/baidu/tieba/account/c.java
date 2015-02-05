package com.baidu.tieba.account;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.amF = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.amF.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(true).setItems(com.baidu.tieba.r.delete_account, new d(this, view)).create().show();
    }
}
