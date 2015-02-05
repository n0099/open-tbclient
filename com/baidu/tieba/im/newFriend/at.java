package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class at implements be {
    final /* synthetic */ NewFriendsActivity blA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.blA = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fx(String str) {
        String str2;
        this.blA.RV();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.blA.blt;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fy(String str) {
        az azVar;
        az azVar2;
        azVar = this.blA.blu;
        azVar.jB();
        azVar2 = this.blA.blu;
        azVar2.setData(null);
        BdToast.a(this.blA.getPageContext().getPageActivity(), str);
    }
}
