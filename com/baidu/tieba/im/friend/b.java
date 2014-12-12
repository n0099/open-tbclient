package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity aZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.aZY = iMBlackListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        h hVar;
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tieba.im.data.a aVar;
        h hVar2;
        com.baidu.tieba.im.data.a aVar2;
        h hVar3;
        h hVar4;
        hVar = this.aZY.aZW;
        hVar.Ok();
        this.aZY.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    hVar3 = this.aZY.aZW;
                    hVar3.E(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.aZY.showToast(responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.fg()) {
                    hVar4 = this.aZY.aZW;
                    hVar4.IX();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() != 0) {
                    this.aZY.showToast(responseUpdateMaskInfoMessage.getErrorString());
                    return;
                }
                this.aZY.showToast(this.aZY.getPageContext().getString(z.black_list_remove_success));
                aVar = this.aZY.aZX;
                if (aVar != null) {
                    hVar2 = this.aZY.aZW;
                    aVar2 = this.aZY.aZX;
                    hVar2.b(aVar2);
                    this.aZY.aZX = null;
                }
            }
        }
    }
}
