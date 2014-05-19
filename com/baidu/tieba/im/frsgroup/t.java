package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(MembersActivity membersActivity, int i) {
        super(i);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ah ahVar;
        ah ahVar2;
        com.baidu.tieba.im.model.ad adVar;
        ah ahVar3;
        ah ahVar4;
        ahVar = this.a.b;
        ahVar.a(false);
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
            this.a.showToast(com.baidu.tieba.u.neterror);
            return;
        }
        ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
        if (responseRemoveMembersMessage.getError() != 0) {
            if (responseRemoveMembersMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseRemoveMembersMessage.getErrorString())) {
                    this.a.showToast(responseRemoveMembersMessage.getErrorString());
                    return;
                }
                return;
            }
            this.a.showToast(com.baidu.tieba.u.neterror);
            return;
        }
        this.a.showToast(com.baidu.tieba.u.members_delete_success);
        ahVar2 = this.a.b;
        ad f = ahVar2.f();
        adVar = this.a.c;
        f.b(adVar.c());
        ahVar3 = this.a.b;
        ahVar3.g();
        ahVar4 = this.a.b;
        ahVar4.f().a();
    }
}
