package com.baidu.tieba.im.newFriend;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ NewFriendsActivity bke;
    private com.baidu.tieba.im.data.b bkf;

    public ay(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.bke = newFriendsActivity;
        this.bkf = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -1:
                if (this.bkf == null) {
                    return;
                }
                this.bke.i(this.bkf);
                return;
            default:
                return;
        }
    }
}
