package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aVU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aVU = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aVU.getPageContext().getPageActivity()).ca(w.l.inform).a(new String[]{this.aVU.getPageContext().getString(w.l.delete_account_only), this.aVU.getPageContext().getString(w.l.delete_account_and_group_cache), this.aVU.getPageContext().getString(w.l.cancel)}, new d(this, view)).d(this.aVU.getPageContext()).tg();
    }
}
