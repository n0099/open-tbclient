package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aLN = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aLN.getPageContext().getPageActivity()).cd(t.j.alert_title).a(new String[]{this.aLN.getPageContext().getString(t.j.delete_account_only), this.aLN.getPageContext().getString(t.j.delete_account_and_group_cache), this.aLN.getPageContext().getString(t.j.delete_account_cancle)}, new d(this, view)).d(this.aLN.getPageContext()).us();
    }
}
