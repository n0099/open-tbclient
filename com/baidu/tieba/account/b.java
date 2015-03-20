package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity auu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.auu = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.e(this.auu.getPageContext().getPageActivity()).by(com.baidu.tieba.y.alert_title).a(new String[]{this.auu.getPageContext().getString(com.baidu.tieba.y.delete_account_only), this.auu.getPageContext().getString(com.baidu.tieba.y.delete_account_and_group_cache), this.auu.getPageContext().getString(com.baidu.tieba.y.delete_account_cancle)}, new c(this, view)).d(this.auu.getPageContext()).rg();
    }
}
