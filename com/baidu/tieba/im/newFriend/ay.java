package com.baidu.tieba.im.newFriend;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ NewFriendsActivity bgY;
    private com.baidu.tieba.im.data.e bgZ;

    public ay(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.e eVar) {
        this.bgY = newFriendsActivity;
        this.bgZ = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -1:
                if (this.bgZ == null) {
                    return;
                }
                this.bgY.h(this.bgZ);
                return;
            default:
                return;
        }
    }
}
