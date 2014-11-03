package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity aWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(InviteFriendListActivity inviteFriendListActivity) {
        this.aWb = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        x xVar;
        x xVar2;
        xVar = this.aWb.aVV;
        if (xVar != null) {
            xVar2 = this.aWb.aVV;
            xVar2.cancelLoadData();
        }
    }
}
