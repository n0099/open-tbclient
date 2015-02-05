package com.baidu.tieba.im.newFriend;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ NewFriendsActivity blA;
    private com.baidu.tieba.im.data.b blB;

    public ay(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.blA = newFriendsActivity;
        this.blB = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -1:
                if (this.blB == null) {
                    return;
                }
                this.blA.i(this.blB);
                return;
            default:
                return;
        }
    }
}
