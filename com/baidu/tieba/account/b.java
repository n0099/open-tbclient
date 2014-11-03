package com.baidu.tieba.account;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity aew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aew = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.aew).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(true).setItems(com.baidu.tieba.q.delete_account, new c(this, view)).create().show();
    }
}
