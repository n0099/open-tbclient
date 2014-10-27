package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GroupActivityActivity aZa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(GroupActivityActivity groupActivityActivity, int i) {
        super(i);
        this.aZa = groupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        r rVar;
        r rVar2;
        r rVar3;
        s sVar;
        if (socketResponsedMessage == null) {
            this.aZa.hideProgressBar();
            this.aZa.showToast(y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103015) {
            this.aZa.hideProgressBar();
            if (!(socketResponsedMessage instanceof ResponseGetGroupActivityMessage)) {
                this.aZa.showToast(y.neterror);
                return;
            }
            ResponseGetGroupActivityMessage responseGetGroupActivityMessage = (ResponseGetGroupActivityMessage) socketResponsedMessage;
            rVar2 = this.aZa.aYZ;
            if (rVar2.getSendMsg() == responseGetGroupActivityMessage.getOrginalMessage()) {
                if (responseGetGroupActivityMessage.getError() == 2230504) {
                    this.aZa.showToast(responseGetGroupActivityMessage.getErrorString(), false);
                    this.aZa.finish();
                } else if (responseGetGroupActivityMessage.getError() == 0) {
                    rVar3 = this.aZa.aYZ;
                    rVar3.a(responseGetGroupActivityMessage.getActivityData());
                    sVar = this.aZa.aYY;
                    sVar.a(responseGetGroupActivityMessage.getActivityData(), false);
                } else {
                    this.aZa.showToast(y.neterror);
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103121) {
            this.aZa.hideProgressBar();
            if (!(socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
                this.aZa.showToast(y.neterror);
                return;
            }
            ResponseDelGroupActivityMessage responseDelGroupActivityMessage = (ResponseDelGroupActivityMessage) socketResponsedMessage;
            rVar = this.aZa.aYZ;
            if (rVar.Oi() == responseDelGroupActivityMessage.getOrginalMessage()) {
                if (responseDelGroupActivityMessage.getError() != 0) {
                    this.aZa.showToast(responseDelGroupActivityMessage.getErrorString());
                    return;
                }
                this.aZa.showToast(y.group_activity_delete_succ, false);
                this.aZa.finish();
            }
        }
    }
}
