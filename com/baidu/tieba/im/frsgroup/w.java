package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1578a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MembersActivity membersActivity) {
        this.f1578a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        ae aeVar;
        ae aeVar2;
        com.baidu.tieba.im.model.h hVar;
        ae aeVar3;
        ae aeVar4;
        aeVar = this.f1578a.f1551a;
        aeVar.a(false);
        if (message == null || !(message instanceof ResponseRemoveMembersMessage)) {
            this.f1578a.b(R.string.neterror);
            return;
        }
        ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) message;
        if (responseRemoveMembersMessage.hasError()) {
            this.f1578a.a(responseRemoveMembersMessage.getErrMsg());
            return;
        }
        this.f1578a.b(R.string.members_delete_success);
        aeVar2 = this.f1578a.f1551a;
        aa i = aeVar2.i();
        hVar = this.f1578a.b;
        i.b(hVar.d());
        aeVar3 = this.f1578a.f1551a;
        aeVar3.j();
        aeVar4 = this.f1578a.f1551a;
        aeVar4.i().a();
    }
}
