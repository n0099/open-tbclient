package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class at implements be {
    final /* synthetic */ NewFriendsActivity blB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.blB = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fA(String str) {
        String str2;
        this.blB.Sa();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.blB.blu;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fB(String str) {
        az azVar;
        az azVar2;
        azVar = this.blB.blv;
        azVar.jI();
        azVar2 = this.blB.blv;
        azVar2.setData(null);
        BdToast.a(this.blB.getPageContext().getPageActivity(), str);
    }
}
