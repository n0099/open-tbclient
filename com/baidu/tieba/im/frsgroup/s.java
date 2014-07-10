package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
class s extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(MembersActivity membersActivity, int i) {
        super(i);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ag agVar;
        ag agVar2;
        com.baidu.tieba.im.model.ac acVar;
        ag agVar3;
        ag agVar4;
        agVar = this.a.b;
        agVar.a(false);
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
            this.a.showToast(com.baidu.tieba.y.neterror);
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
            this.a.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        this.a.showToast(com.baidu.tieba.y.members_delete_success);
        agVar2 = this.a.b;
        ac f = agVar2.f();
        acVar = this.a.c;
        f.b(acVar.c());
        agVar3 = this.a.b;
        agVar3.g();
        agVar4 = this.a.b;
        agVar4.f().a();
    }
}
