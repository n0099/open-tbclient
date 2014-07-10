package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.a.c;
        if (aeVar != null) {
            aeVar2 = this.a.c;
            aeVar2.cancelLoadData();
        }
    }
}
