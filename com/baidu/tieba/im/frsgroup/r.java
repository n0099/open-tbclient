package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
class r extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(MembersActivity membersActivity, int i) {
        super(i);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        af afVar;
        af afVar2;
        com.baidu.tieba.im.model.u uVar;
        af afVar3;
        af afVar4;
        afVar = this.a.b;
        afVar.a(false);
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
            this.a.showToast(com.baidu.tieba.x.neterror);
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
            this.a.showToast(com.baidu.tieba.x.neterror);
            return;
        }
        this.a.showToast(com.baidu.tieba.x.members_delete_success);
        afVar2 = this.a.b;
        ab f = afVar2.f();
        uVar = this.a.c;
        f.b(uVar.c());
        afVar3 = this.a.b;
        afVar3.g();
        afVar4 = this.a.b;
        afVar4.f().a();
    }
}
