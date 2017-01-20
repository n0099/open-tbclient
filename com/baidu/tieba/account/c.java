package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aPx = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aPx.getPageContext().getPageActivity()).cd(r.l.alert_title).a(new String[]{this.aPx.getPageContext().getString(r.l.delete_account_only), this.aPx.getPageContext().getString(r.l.delete_account_and_group_cache), this.aPx.getPageContext().getString(r.l.delete_account_cancle)}, new d(this, view)).d(this.aPx.getPageContext()).sY();
    }
}
