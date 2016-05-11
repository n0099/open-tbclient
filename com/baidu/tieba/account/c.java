package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aHY = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aHY.getPageContext().getPageActivity()).bP(t.j.alert_title).a(new String[]{this.aHY.getPageContext().getString(t.j.delete_account_only), this.aHY.getPageContext().getString(t.j.delete_account_and_group_cache), this.aHY.getPageContext().getString(t.j.delete_account_cancle)}, new d(this, view)).d(this.aHY.getPageContext()).rX();
    }
}
