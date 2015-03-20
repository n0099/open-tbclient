package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class az implements com.baidu.tbadk.core.dialog.h {
    private com.baidu.tieba.im.data.b ayA;
    final /* synthetic */ NewFriendsActivity ayz;

    public az(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.ayz = newFriendsActivity;
        this.ayA = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.ayA == null) {
            return;
        }
        this.ayz.f(this.ayA);
    }
}
