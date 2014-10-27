package com.baidu.tieba.account.appeal;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ AppealActivity afT;
    private final /* synthetic */ boolean afV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.afT = appealActivity;
        this.afV = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.afT);
        }
        if (this.afV) {
            this.afT.finish();
        }
    }
}
