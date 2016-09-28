package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aSN = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aSN.getPageContext().getPageActivity()).cc(r.j.alert_title).a(new String[]{this.aSN.getPageContext().getString(r.j.delete_account_only), this.aSN.getPageContext().getString(r.j.delete_account_and_group_cache), this.aSN.getPageContext().getString(r.j.delete_account_cancle)}, new d(this, view)).d(this.aSN.getPageContext()).tp();
    }
}
