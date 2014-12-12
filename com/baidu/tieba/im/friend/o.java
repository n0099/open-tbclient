package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(InviteFriendListActivity inviteFriendListActivity) {
        this.bas = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        x xVar;
        x xVar2;
        xVar = this.bas.bal;
        if (xVar != null) {
            xVar2 = this.bas.bal;
            xVar2.cancelLoadData();
        }
    }
}
