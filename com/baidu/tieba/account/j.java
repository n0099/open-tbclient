package com.baidu.tieba.account;

import android.content.DialogInterface;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
/* loaded from: classes.dex */
class j implements DialogInterface.OnCancelListener {
    final /* synthetic */ i aeC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aeC = iVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.aeC.aew;
        accountActivity.destroyWaitingDialog();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, "account changed");
    }
}
