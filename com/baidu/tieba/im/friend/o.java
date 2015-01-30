package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity bbO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(InviteFriendListActivity inviteFriendListActivity) {
        this.bbO = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        x xVar;
        x xVar2;
        xVar = this.bbO.bbI;
        if (xVar != null) {
            xVar2 = this.bbO.bbI;
            xVar2.cancelLoadData();
        }
    }
}
