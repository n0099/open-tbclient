package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ GroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(GroupActivityActivity groupActivityActivity, int i) {
        super(i);
        this.a = groupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        r rVar;
        r rVar2;
        r rVar3;
        s sVar;
        if (socketResponsedMessage == null) {
            this.a.hideProgressBar();
            this.a.showToast(y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103015) {
            this.a.hideProgressBar();
            if (!(socketResponsedMessage instanceof ResponseGetGroupActivityMessage)) {
                this.a.showToast(y.neterror);
                return;
            }
            ResponseGetGroupActivityMessage responseGetGroupActivityMessage = (ResponseGetGroupActivityMessage) socketResponsedMessage;
            rVar2 = this.a.b;
            if (rVar2.e() == responseGetGroupActivityMessage.getOrginalMessage()) {
                if (responseGetGroupActivityMessage.getError() == 2230504) {
                    this.a.showToast(responseGetGroupActivityMessage.getErrorString(), false);
                    this.a.finish();
                } else if (responseGetGroupActivityMessage.getError() == 0) {
                    rVar3 = this.a.b;
                    rVar3.a(responseGetGroupActivityMessage.getActivityData());
                    sVar = this.a.a;
                    sVar.a(responseGetGroupActivityMessage.getActivityData(), false);
                } else {
                    this.a.showToast(y.neterror);
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103121) {
            this.a.hideProgressBar();
            if (!(socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
                this.a.showToast(y.neterror);
                return;
            }
            ResponseDelGroupActivityMessage responseDelGroupActivityMessage = (ResponseDelGroupActivityMessage) socketResponsedMessage;
            rVar = this.a.b;
            if (rVar.f() == responseDelGroupActivityMessage.getOrginalMessage()) {
                if (responseDelGroupActivityMessage.getError() != 0) {
                    this.a.showToast(responseDelGroupActivityMessage.getErrorString());
                    return;
                }
                this.a.showToast(y.group_activity_delete_succ, false);
                this.a.finish();
            }
        }
    }
}
