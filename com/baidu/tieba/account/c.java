package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aRI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aRI = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aRI.getPageContext().getPageActivity()).cc(t.j.alert_title).a(new String[]{this.aRI.getPageContext().getString(t.j.delete_account_only), this.aRI.getPageContext().getString(t.j.delete_account_and_group_cache), this.aRI.getPageContext().getString(t.j.delete_account_cancle)}, new d(this, view)).d(this.aRI.getPageContext()).ta();
    }
}
