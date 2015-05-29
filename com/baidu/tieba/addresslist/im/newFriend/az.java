package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class az implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ NewFriendsActivity aAs;
    private com.baidu.tieba.im.data.b aAt;

    public az(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.aAs = newFriendsActivity;
        this.aAt = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.aAt == null) {
            return;
        }
        this.aAs.f(this.aAt);
    }
}
