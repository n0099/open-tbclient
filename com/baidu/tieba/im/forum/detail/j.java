package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ h baE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int i) {
        super(i);
        this.baE = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        l lVar;
        l lVar2;
        ForumDetailActivity forumDetailActivity;
        l lVar3;
        l lVar4;
        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
            if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 12) {
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        forumDetailActivity = this.baE.baC;
                        forumDetailActivity.showToast(responseUpdateMaskInfoMessage.getErrorString());
                        if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            lVar4 = this.baE.baD;
                            lVar4.cM(false);
                            return;
                        }
                        lVar3 = this.baE.baD;
                        lVar3.cN(false);
                    } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        lVar2 = this.baE.baD;
                        lVar2.cM(true);
                    } else {
                        lVar = this.baE.baD;
                        lVar.cN(true);
                    }
                }
            }
        }
    }
}
