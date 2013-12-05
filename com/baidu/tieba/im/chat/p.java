package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.GroupDeleteMsgResponsedMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.f1602a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        u uVar;
        this.f1602a.f1600a.closeLoadingDialog();
        GroupDeleteMsgResponsedMessage groupDeleteMsgResponsedMessage = new GroupDeleteMsgResponsedMessage();
        uVar = this.f1602a.f1600a.b;
        groupDeleteMsgResponsedMessage.setGroupId(uVar.c());
        com.baidu.tieba.im.messageCenter.e.a().e(groupDeleteMsgResponsedMessage);
        this.f1602a.f1600a.showToast(R.string.cash_del_suc, false);
    }
}
