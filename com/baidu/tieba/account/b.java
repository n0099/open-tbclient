package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity aEl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aEl = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aEl.getPageContext().getPageActivity()).bI(i.h.alert_title).a(new String[]{this.aEl.getPageContext().getString(i.h.delete_account_only), this.aEl.getPageContext().getString(i.h.delete_account_and_group_cache), this.aEl.getPageContext().getString(i.h.delete_account_cancle)}, new c(this, view)).d(this.aEl.getPageContext()).sU();
    }
}
