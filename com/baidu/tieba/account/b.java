package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity aDq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aDq = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aDq.getPageContext().getPageActivity()).bI(i.h.alert_title).a(new String[]{this.aDq.getPageContext().getString(i.h.delete_account_only), this.aDq.getPageContext().getString(i.h.delete_account_and_group_cache), this.aDq.getPageContext().getString(i.h.delete_account_cancle)}, new c(this, view)).d(this.aDq.getPageContext()).sU();
    }
}
