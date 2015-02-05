package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity bbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.bbu = iMBlackListActivity;
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
        hVar = this.bbu.bbs;
        hVar.OB();
        this.bbu.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    hVar3 = this.bbu.bbs;
                    hVar3.F(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.bbu.showToast(responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.ff()) {
                    hVar4 = this.bbu.bbs;
                    hVar4.Jq();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() != 0) {
                    this.bbu.showToast(responseUpdateMaskInfoMessage.getErrorString());
                    return;
                }
                this.bbu.showToast(this.bbu.getPageContext().getString(z.black_list_remove_success));
                aVar = this.bbu.bbt;
                if (aVar != null) {
                    hVar2 = this.bbu.bbs;
                    aVar2 = this.bbu.bbt;
                    hVar2.b(aVar2);
                    this.bbu.bbt = null;
                }
            }
        }
    }
}
