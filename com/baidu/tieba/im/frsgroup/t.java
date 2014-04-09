package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
final class t extends com.baidu.adp.framework.c.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(MembersActivity membersActivity, int i) {
        super(103112);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        ah ahVar;
        ah ahVar2;
        com.baidu.tieba.im.model.z zVar;
        ah ahVar3;
        ah ahVar4;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        ahVar = this.a.b;
        ahVar.a(false);
        if (socketResponsedMessage2 == null || !(socketResponsedMessage2 instanceof ResponseRemoveMembersMessage)) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
            return;
        }
        ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage2;
        if (responseRemoveMembersMessage.e() != 0) {
            if (responseRemoveMembersMessage.e() <= 0) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            } else if (TextUtils.isEmpty(responseRemoveMembersMessage.f())) {
                return;
            } else {
                this.a.showToast(responseRemoveMembersMessage.f());
                return;
            }
        }
        this.a.showToast(com.baidu.tieba.im.j.members_delete_success);
        ahVar2 = this.a.b;
        ad h = ahVar2.h();
        zVar = this.a.c;
        h.b(zVar.c());
        ahVar3 = this.a.b;
        ahVar3.i();
        ahVar4 = this.a.b;
        ahVar4.h().a();
    }
}
