package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aVw = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aVw.getPageContext().getPageActivity()).cc(w.l.inform).a(new String[]{this.aVw.getPageContext().getString(w.l.delete_account_only), this.aVw.getPageContext().getString(w.l.delete_account_and_group_cache), this.aVw.getPageContext().getString(w.l.cancel)}, new d(this, view)).d(this.aVw.getPageContext()).tT();
    }
}
