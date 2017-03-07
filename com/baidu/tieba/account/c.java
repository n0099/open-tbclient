package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AccountActivity aVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccountActivity accountActivity) {
        this.aVj = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.c(this.aVj.getPageContext().getPageActivity()).bZ(w.l.alert_title).a(new String[]{this.aVj.getPageContext().getString(w.l.delete_account_only), this.aVj.getPageContext().getString(w.l.delete_account_and_group_cache), this.aVj.getPageContext().getString(w.l.delete_account_cancle)}, new d(this, view)).d(this.aVj.getPageContext()).tv();
    }
}
