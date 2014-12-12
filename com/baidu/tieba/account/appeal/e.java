package com.baidu.tieba.account.appeal;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ AppealActivity ans;
    private final /* synthetic */ boolean anu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.ans = appealActivity;
        this.anu = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.ans.getPageContext());
        }
        if (this.anu) {
            this.ans.finish();
        }
    }
}
