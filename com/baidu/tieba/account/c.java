package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity awg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.awg = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.e(this.awg.getPageContext().getPageActivity()).bx(com.baidu.tieba.t.alert_title).a(new String[]{this.awg.getPageContext().getString(com.baidu.tieba.t.delete_account_only), this.awg.getPageContext().getString(com.baidu.tieba.t.delete_account_and_group_cache), this.awg.getPageContext().getString(com.baidu.tieba.t.delete_account_cancle)}, new d(this, view)).d(this.awg.getPageContext()).rN();
    }
}
