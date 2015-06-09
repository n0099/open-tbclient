package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class au implements bg {
    final /* synthetic */ NewFriendsActivity aAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewFriendsActivity newFriendsActivity) {
        this.aAt = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void fA(String str) {
        String str2;
        this.aAt.FU();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.aAt.aAl;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void fB(String str) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.aAt.aAm;
        bbVar.completePullRefresh();
        bbVar2 = this.aAt.aAm;
        bbVar2.setData(null);
        BdToast.a(this.aAt.getPageContext().getPageActivity(), str);
    }
}
