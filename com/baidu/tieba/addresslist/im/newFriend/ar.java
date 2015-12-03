package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.addresslist.im.newFriend.ay;
/* loaded from: classes.dex */
class ar implements ay.a {
    final /* synthetic */ NewFriendsActivity aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewFriendsActivity newFriendsActivity) {
        this.aIX = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.ay.a
    public void gt(String str) {
        String str2;
        this.aIX.Ho();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.aIX.aIP;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.ay.a
    public void bK(String str) {
        ax axVar;
        ax axVar2;
        axVar = this.aIX.aIQ;
        axVar.completePullRefresh();
        axVar2 = this.aIX.aIQ;
        axVar2.setData(null);
        BdToast.b(this.aIX.getPageContext().getPageActivity(), str);
    }
}
