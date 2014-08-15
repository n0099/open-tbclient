package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        w wVar;
        w wVar2;
        wVar = this.a.c;
        if (wVar != null) {
            wVar2 = this.a.c;
            wVar2.cancelLoadData();
        }
    }
}
