package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MembersActivity membersActivity) {
        this.f1720a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        aa aaVar;
        aa aaVar2;
        com.baidu.tieba.im.model.h hVar;
        aa aaVar3;
        aa aaVar4;
        aaVar = this.f1720a.b;
        aaVar.a(false);
        if (message == null || !(message instanceof ResponseRemoveMembersMessage)) {
            this.f1720a.showToast(R.string.neterror);
            return;
        }
        ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) message;
        if (responseRemoveMembersMessage.hasError()) {
            if (responseRemoveMembersMessage.getErrNo() > 0) {
                if (!TextUtils.isEmpty(responseRemoveMembersMessage.getErrMsg())) {
                    this.f1720a.showToast(responseRemoveMembersMessage.getErrMsg());
                    return;
                }
                return;
            }
            this.f1720a.showToast(R.string.neterror);
            return;
        }
        this.f1720a.showToast(R.string.members_delete_success);
        aaVar2 = this.f1720a.b;
        w i = aaVar2.i();
        hVar = this.f1720a.c;
        i.b(hVar.d());
        aaVar3 = this.f1720a.b;
        aaVar3.j();
        aaVar4 = this.f1720a.b;
        aaVar4.i().a();
    }
}
