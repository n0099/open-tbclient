package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aIQ = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aIQ.getPageContext().getPageActivity()).cb(t.j.alert_title).a(new String[]{this.aIQ.getPageContext().getString(t.j.delete_account_only), this.aIQ.getPageContext().getString(t.j.delete_account_and_group_cache), this.aIQ.getPageContext().getString(t.j.delete_account_cancle)}, new d(this, view)).d(this.aIQ.getPageContext()).un();
    }
}
