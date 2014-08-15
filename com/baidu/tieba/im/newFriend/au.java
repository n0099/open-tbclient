package com.baidu.tieba.im.newFriend;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class au implements DialogInterface.OnClickListener {
    final /* synthetic */ NewFriendsActivity a;
    private com.baidu.tieba.im.data.k b;

    public au(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.k kVar) {
        this.a = newFriendsActivity;
        this.b = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -1:
                if (this.b == null) {
                    return;
                }
                this.a.c(this.b);
                return;
            default:
                return;
        }
    }
}
