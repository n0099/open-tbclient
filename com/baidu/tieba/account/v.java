package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class v implements DialogInterface.OnCancelListener {
    final /* synthetic */ u aMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aMG = uVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.aMG.aMF;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
