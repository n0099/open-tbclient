package com.baidu.tieba.account;

import android.content.DialogInterface;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
/* loaded from: classes.dex */
class j implements DialogInterface.OnCancelListener {
    final /* synthetic */ i alU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.alU = iVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.alU.alO;
        accountActivity.destroyWaitingDialog();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, "account changed");
    }
}
