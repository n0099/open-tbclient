package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class au implements bg {
    final /* synthetic */ NewFriendsActivity aAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewFriendsActivity newFriendsActivity) {
        this.aAs = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void fA(String str) {
        String str2;
        this.aAs.FT();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.aAs.aAk;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void fB(String str) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.aAs.aAl;
        bbVar.completePullRefresh();
        bbVar2 = this.aAs.aAl;
        bbVar2.setData(null);
        BdToast.a(this.aAs.getPageContext().getPageActivity(), str);
    }
}
