package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity aGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aGn = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aGn.getPageContext().getPageActivity()).bQ(n.i.alert_title).a(new String[]{this.aGn.getPageContext().getString(n.i.delete_account_only), this.aGn.getPageContext().getString(n.i.delete_account_and_group_cache), this.aGn.getPageContext().getString(n.i.delete_account_cancle)}, new c(this, view)).d(this.aGn.getPageContext()).tz();
    }
}
