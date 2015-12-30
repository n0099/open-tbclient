package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aHO = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aHO.getPageContext().getPageActivity()).bJ(n.j.alert_title).a(new String[]{this.aHO.getPageContext().getString(n.j.delete_account_only), this.aHO.getPageContext().getString(n.j.delete_account_and_group_cache), this.aHO.getPageContext().getString(n.j.delete_account_cancle)}, new d(this, view)).d(this.aHO.getPageContext()).tj();
    }
}
