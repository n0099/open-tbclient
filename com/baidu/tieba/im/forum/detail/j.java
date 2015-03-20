package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ h bcG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int i) {
        super(i);
        this.bcG = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        l lVar;
        l lVar2;
        String errorString;
        ForumDetailActivity forumDetailActivity;
        l lVar3;
        l lVar4;
        ForumDetailActivity forumDetailActivity2;
        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
            if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 12) {
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                            forumDetailActivity2 = this.bcG.bcE;
                            errorString = forumDetailActivity2.getResources().getString(com.baidu.tieba.y.neterror);
                        } else {
                            errorString = responseUpdateMaskInfoMessage.getErrorString();
                        }
                        forumDetailActivity = this.bcG.bcE;
                        forumDetailActivity.showToast(errorString);
                        if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            lVar4 = this.bcG.bcF;
                            lVar4.cA(false);
                            return;
                        }
                        lVar3 = this.bcG.bcF;
                        lVar3.cB(false);
                    } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        lVar2 = this.bcG.bcF;
                        lVar2.cA(true);
                    } else {
                        lVar = this.bcG.bcF;
                        lVar.cB(true);
                    }
                }
            }
        }
    }
}
