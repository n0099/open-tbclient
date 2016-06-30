package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aLu = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aLu.getPageContext().getPageActivity()).bP(u.j.alert_title).a(new String[]{this.aLu.getPageContext().getString(u.j.delete_account_only), this.aLu.getPageContext().getString(u.j.delete_account_and_group_cache), this.aLu.getPageContext().getString(u.j.delete_account_cancle)}, new d(this, view)).d(this.aLu.getPageContext()).rW();
    }
}
