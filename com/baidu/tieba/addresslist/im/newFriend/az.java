package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class az implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ NewFriendsActivity aAt;
    private com.baidu.tieba.im.data.b aAu;

    public az(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.aAt = newFriendsActivity;
        this.aAu = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.aAu == null) {
            return;
        }
        this.aAt.f(this.aAu);
    }
}
