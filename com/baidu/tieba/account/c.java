package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aUO = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aUO.getPageContext().getPageActivity()).cd(r.j.alert_title).a(new String[]{this.aUO.getPageContext().getString(r.j.delete_account_only), this.aUO.getPageContext().getString(r.j.delete_account_and_group_cache), this.aUO.getPageContext().getString(r.j.delete_account_cancle)}, new d(this, view)).d(this.aUO.getPageContext()).tt();
    }
}
