package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class at implements be {
    final /* synthetic */ NewFriendsActivity bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.bhm = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fa(String str) {
        String str2;
        this.bhm.Rk();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.bhm.bhf;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fb(String str) {
        az azVar;
        az azVar2;
        azVar = this.bhm.bhg;
        azVar.hN();
        azVar2 = this.bhm.bhg;
        azVar2.setData(null);
        BdToast.a(this.bhm, str);
    }
}
