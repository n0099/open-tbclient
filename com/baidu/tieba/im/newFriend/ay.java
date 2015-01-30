package com.baidu.tieba.im.newFriend;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ NewFriendsActivity blB;
    private com.baidu.tieba.im.data.b blC;

    public ay(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.blB = newFriendsActivity;
        this.blC = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -1:
                if (this.blC == null) {
                    return;
                }
                this.blB.i(this.blC);
                return;
            default:
                return;
        }
    }
}
