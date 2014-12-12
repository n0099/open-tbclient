package com.baidu.tieba.account;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity alO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.alO = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.alO.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(true).setItems(com.baidu.tieba.r.delete_account, new c(this, view)).create().show();
    }
}
