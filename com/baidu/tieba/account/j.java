package com.baidu.tieba.account;

import android.content.DialogInterface;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
/* loaded from: classes.dex */
class j implements DialogInterface.OnCancelListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.a.a;
        accountActivity.destroyWaitingDialog();
        BdSocketLinkService.startService(true, "account changed");
    }
}
