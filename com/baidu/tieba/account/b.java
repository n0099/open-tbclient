package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aFg = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aFg.getPageContext().getPageActivity()).bI(i.h.alert_title).a(new String[]{this.aFg.getPageContext().getString(i.h.delete_account_only), this.aFg.getPageContext().getString(i.h.delete_account_and_group_cache), this.aFg.getPageContext().getString(i.h.delete_account_cancle)}, new c(this, view)).d(this.aFg.getPageContext()).sX();
    }
}
