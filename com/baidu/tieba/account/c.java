package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aUf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aUf = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aUf.getPageContext().getPageActivity()).ce(r.j.alert_title).a(new String[]{this.aUf.getPageContext().getString(r.j.delete_account_only), this.aUf.getPageContext().getString(r.j.delete_account_and_group_cache), this.aUf.getPageContext().getString(r.j.delete_account_cancle)}, new d(this, view)).d(this.aUf.getPageContext()).te();
    }
}
