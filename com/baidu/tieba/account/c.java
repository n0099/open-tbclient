package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aUP = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aUP.getPageContext().getPageActivity()).cb(w.l.inform).a(new String[]{this.aUP.getPageContext().getString(w.l.delete_account_only), this.aUP.getPageContext().getString(w.l.delete_account_and_group_cache), this.aUP.getPageContext().getString(w.l.cancel)}, new d(this, view)).d(this.aUP.getPageContext()).td();
    }
}
