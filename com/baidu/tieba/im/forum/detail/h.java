package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ f aZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, int i) {
        super(i);
        this.aZh = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        j jVar;
        j jVar2;
        ForumDetailActivity forumDetailActivity;
        j jVar3;
        j jVar4;
        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
            if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 12) {
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        forumDetailActivity = this.aZh.aZf;
                        forumDetailActivity.showToast(responseUpdateMaskInfoMessage.getErrorString());
                        if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            jVar4 = this.aZh.aZg;
                            jVar4.cH(false);
                            return;
                        }
                        jVar3 = this.aZh.aZg;
                        jVar3.cI(false);
                    } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        jVar2 = this.aZh.aZg;
                        jVar2.cH(true);
                    } else {
                        jVar = this.aZh.aZg;
                        jVar.cI(true);
                    }
                }
            }
        }
    }
}
