package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class au implements bg {
    final /* synthetic */ NewFriendsActivity ayz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewFriendsActivity newFriendsActivity) {
        this.ayz = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void fc(String str) {
        String str2;
        this.ayz.EU();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.ayz.ayr;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void fd(String str) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.ayz.ays;
        bbVar.mW();
        bbVar2 = this.ayz.ays;
        bbVar2.setData(null);
        BdToast.a(this.ayz.getPageContext().getPageActivity(), str);
    }
}
