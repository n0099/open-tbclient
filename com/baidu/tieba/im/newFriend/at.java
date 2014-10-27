package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class at implements be {
    final /* synthetic */ NewFriendsActivity bgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.bgY = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fa(String str) {
        String str2;
        this.bgY.Rh();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.bgY.bgR;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fb(String str) {
        az azVar;
        az azVar2;
        azVar = this.bgY.bgS;
        azVar.hN();
        azVar2 = this.bgY.bgS;
        azVar2.setData(null);
        BdToast.a(this.bgY, str);
    }
}
