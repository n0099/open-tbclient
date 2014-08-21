package com.baidu.tieba.account.appeal;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ AppealActivity a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.a = appealActivity;
        this.b = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
        }
        if (this.b) {
            this.a.finish();
        }
    }
}
