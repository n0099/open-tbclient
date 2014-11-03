package com.baidu.tieba.im.newFriend;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ NewFriendsActivity bhm;
    private com.baidu.tieba.im.data.e bhn;

    public ay(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.e eVar) {
        this.bhm = newFriendsActivity;
        this.bhn = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -1:
                if (this.bhn == null) {
                    return;
                }
                this.bhm.h(this.bhn);
                return;
            default:
                return;
        }
    }
}
