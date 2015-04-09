package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class az implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ NewFriendsActivity ayH;
    private com.baidu.tieba.im.data.b ayI;

    public az(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.ayH = newFriendsActivity;
        this.ayI = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.ayI == null) {
            return;
        }
        this.ayH.f(this.ayI);
    }
}
