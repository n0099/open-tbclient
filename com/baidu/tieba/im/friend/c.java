package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
/* loaded from: classes.dex */
final class c extends com.baidu.adp.framework.c.g {
    final /* synthetic */ IMBlackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(IMBlackListActivity iMBlackListActivity, int i) {
        super(0);
        this.a = iMBlackListActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        i iVar;
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        com.baidu.adp.framework.message.d<?> h;
        com.baidu.tieba.im.data.a aVar;
        i iVar2;
        com.baidu.tieba.im.data.a aVar2;
        i iVar3;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        iVar = this.a.b;
        iVar.d();
        this.a.closeLoadingDialog();
        if (socketResponsedMessage2 != null) {
            if (socketResponsedMessage2.g() == 104103 && (socketResponsedMessage2 instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage2;
                if (responseGetMaskInfoMessage.e() != 0) {
                    this.a.showToast(responseGetMaskInfoMessage.f());
                    return;
                }
                iVar3 = this.a.b;
                iVar3.a(responseGetMaskInfoMessage.i());
            } else if (socketResponsedMessage2.g() == 104102 && (socketResponsedMessage2 instanceof ResponseUpdateMaskInfoMessage) && (h = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage2).h()) != null && (h instanceof com.baidu.tbadk.core.message.d) && ((com.baidu.tbadk.core.message.d) h).i() == 10) {
                if (responseUpdateMaskInfoMessage.e() != 0) {
                    this.a.showToast(responseUpdateMaskInfoMessage.f());
                    return;
                }
                this.a.showToast(this.a.getString(com.baidu.tieba.im.j.black_list_remove_success));
                aVar = this.a.c;
                if (aVar != null) {
                    iVar2 = this.a.b;
                    aVar2 = this.a.c;
                    iVar2.a(aVar2);
                    this.a.c = null;
                }
            }
        }
    }
}
