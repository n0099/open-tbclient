package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AccountActivity aEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.aEw = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aEw.getPageContext().getPageActivity()).bI(i.h.alert_title).a(new String[]{this.aEw.getPageContext().getString(i.h.delete_account_only), this.aEw.getPageContext().getString(i.h.delete_account_and_group_cache), this.aEw.getPageContext().getString(i.h.delete_account_cancle)}, new c(this, view)).d(this.aEw.getPageContext()).sR();
    }
}
