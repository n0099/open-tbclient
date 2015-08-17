package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity aDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aDy = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aDy.getPageContext().getPageActivity()).bF(i.C0057i.alert_title).a(new String[]{this.aDy.getPageContext().getString(i.C0057i.delete_account_only), this.aDy.getPageContext().getString(i.C0057i.delete_account_and_group_cache), this.aDy.getPageContext().getString(i.C0057i.delete_account_cancle)}, new c(this, view)).d(this.aDy.getPageContext()).sS();
    }
}
