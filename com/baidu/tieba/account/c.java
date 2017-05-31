package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aTw = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aTw.getPageContext().getPageActivity()).cb(w.l.inform).a(new String[]{this.aTw.getPageContext().getString(w.l.delete_account_only), this.aTw.getPageContext().getString(w.l.delete_account_and_group_cache), this.aTw.getPageContext().getString(w.l.cancel)}, new d(this, view)).d(this.aTw.getPageContext()).tf();
    }
}
