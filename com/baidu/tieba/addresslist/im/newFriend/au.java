package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
/* loaded from: classes.dex */
class au implements bg {
    final /* synthetic */ NewFriendsActivity ayH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewFriendsActivity newFriendsActivity) {
        this.ayH = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void ff(String str) {
        String str2;
        this.ayH.Fa();
        TbadkSettings inst = TbadkSettings.getInst();
        str2 = this.ayH.ayz;
        inst.saveBoolean(str2, true);
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.bg
    public void fg(String str) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.ayH.ayA;
        bbVar.mW();
        bbVar2 = this.ayH.ayA;
        bbVar2.setData(null);
        BdToast.a(this.ayH.getPageContext().getPageActivity(), str);
    }
}
