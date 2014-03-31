package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
/* loaded from: classes.dex */
final class o extends com.baidu.adp.framework.c.g {
    final /* synthetic */ GroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(GroupActivityActivity groupActivityActivity, int i) {
        super(0);
        this.a = groupActivityActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        r rVar;
        r rVar2;
        r rVar3;
        s sVar;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null) {
            this.a.hideProgressBar();
            this.a.showToast(com.baidu.tieba.im.j.neterror);
        } else if (socketResponsedMessage2.g() != 103015) {
            if (socketResponsedMessage2.g() == 103121) {
                this.a.hideProgressBar();
                if (!(socketResponsedMessage2 instanceof ResponseDelGroupActivityMessage)) {
                    this.a.showToast(com.baidu.tieba.im.j.neterror);
                    return;
                }
                ResponseDelGroupActivityMessage responseDelGroupActivityMessage = (ResponseDelGroupActivityMessage) socketResponsedMessage2;
                rVar = this.a.b;
                if (rVar.f() == responseDelGroupActivityMessage.h()) {
                    if (responseDelGroupActivityMessage.e() != 0) {
                        this.a.showToast(responseDelGroupActivityMessage.f());
                        return;
                    }
                    this.a.showToast(com.baidu.tieba.im.j.group_activity_delete_succ, false);
                    this.a.finish();
                }
            }
        } else {
            this.a.hideProgressBar();
            if (!(socketResponsedMessage2 instanceof ResponseGetGroupActivityMessage)) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            }
            ResponseGetGroupActivityMessage responseGetGroupActivityMessage = (ResponseGetGroupActivityMessage) socketResponsedMessage2;
            rVar2 = this.a.b;
            if (rVar2.e() == responseGetGroupActivityMessage.h()) {
                if (responseGetGroupActivityMessage.e() == 2230504) {
                    this.a.showToast(responseGetGroupActivityMessage.f(), false);
                    this.a.finish();
                } else if (responseGetGroupActivityMessage.e() != 0) {
                    this.a.showToast(com.baidu.tieba.im.j.neterror);
                } else {
                    rVar3 = this.a.b;
                    rVar3.a(responseGetGroupActivityMessage.d());
                    sVar = this.a.a;
                    sVar.a(responseGetGroupActivityMessage.d(), false);
                }
            }
        }
    }
}
