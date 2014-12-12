package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class at implements be {
    final /* synthetic */ NewFriendsActivity bke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.bke = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fv(String str) {
        String str2;
        this.bke.RE();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.bke.bjX;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void fw(String str) {
        az azVar;
        az azVar2;
        azVar = this.bke.bjY;
        azVar.jJ();
        azVar2 = this.bke.bjY;
        azVar2.setData(null);
        BdToast.a(this.bke.getPageContext().getPageActivity(), str);
    }
}
