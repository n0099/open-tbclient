package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GroupActivityActivity aZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(GroupActivityActivity groupActivityActivity, int i) {
        super(i);
        this.aZn = groupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        r rVar;
        r rVar2;
        r rVar3;
        s sVar;
        if (socketResponsedMessage == null) {
            this.aZn.hideProgressBar();
            this.aZn.showToast(y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103015) {
            this.aZn.hideProgressBar();
            if (!(socketResponsedMessage instanceof ResponseGetGroupActivityMessage)) {
                this.aZn.showToast(y.neterror);
                return;
            }
            ResponseGetGroupActivityMessage responseGetGroupActivityMessage = (ResponseGetGroupActivityMessage) socketResponsedMessage;
            rVar2 = this.aZn.aZm;
            if (rVar2.getSendMsg() == responseGetGroupActivityMessage.getOrginalMessage()) {
                if (responseGetGroupActivityMessage.getError() == 2230504) {
                    this.aZn.showToast(responseGetGroupActivityMessage.getErrorString(), false);
                    this.aZn.finish();
                } else if (responseGetGroupActivityMessage.getError() == 0) {
                    rVar3 = this.aZn.aZm;
                    rVar3.a(responseGetGroupActivityMessage.getActivityData());
                    sVar = this.aZn.aZl;
                    sVar.a(responseGetGroupActivityMessage.getActivityData(), false);
                } else {
                    this.aZn.showToast(y.neterror);
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103121) {
            this.aZn.hideProgressBar();
            if (!(socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
                this.aZn.showToast(y.neterror);
                return;
            }
            ResponseDelGroupActivityMessage responseDelGroupActivityMessage = (ResponseDelGroupActivityMessage) socketResponsedMessage;
            rVar = this.aZn.aZm;
            if (rVar.Ol() == responseDelGroupActivityMessage.getOrginalMessage()) {
                if (responseDelGroupActivityMessage.getError() != 0) {
                    this.aZn.showToast(responseDelGroupActivityMessage.getErrorString());
                    return;
                }
                this.aZn.showToast(y.group_activity_delete_succ, false);
                this.aZn.finish();
            }
        }
    }
}
