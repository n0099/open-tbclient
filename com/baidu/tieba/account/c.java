package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aMo = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aMo.getPageContext().getPageActivity()).bP(u.j.alert_title).a(new String[]{this.aMo.getPageContext().getString(u.j.delete_account_only), this.aMo.getPageContext().getString(u.j.delete_account_and_group_cache), this.aMo.getPageContext().getString(u.j.delete_account_cancle)}, new d(this, view)).d(this.aMo.getPageContext()).rV();
    }
}
