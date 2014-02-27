package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.h hVar;
        com.baidu.tieba.im.model.h hVar2;
        hVar = this.a.b;
        if (hVar != null) {
            hVar2 = this.a.b;
            hVar2.cancelLoadData();
        }
    }
}
