package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.a.a;
        accountActivity.DeinitWaitingDialog();
    }
}
