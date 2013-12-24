package com.baidu.tieba.account.appeal;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ AppealActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.b = appealActivity;
        this.a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.a) {
            this.b.finish();
        }
    }
}
