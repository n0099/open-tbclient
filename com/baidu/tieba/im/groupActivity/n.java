package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ GroupActivityActivity aZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupActivityActivity groupActivityActivity, int i) {
        super(i);
        this.aZn = groupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        r rVar;
        s sVar;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        if (!(customResponsedMessage instanceof ResponseGetGroupActivityLocalMessage)) {
            rVar7 = this.aZn.aZm;
            rVar8 = this.aZn.aZm;
            rVar7.sendMessage(rVar8.Oj());
            return;
        }
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage;
        rVar = this.aZn.aZm;
        if (rVar.getLocalSendMsg() == responseGetGroupActivityLocalMessage.getOrginalMessage()) {
            if (responseGetGroupActivityLocalMessage.getError() == 0) {
                sVar = this.aZn.aZl;
                sVar.a(responseGetGroupActivityLocalMessage.getActivityData(), true);
                rVar2 = this.aZn.aZm;
                rVar2.a(responseGetGroupActivityLocalMessage.getActivityData());
                rVar3 = this.aZn.aZm;
                rVar4 = this.aZn.aZm;
                rVar3.sendMessage(rVar4.Oj());
                return;
            }
            rVar5 = this.aZn.aZm;
            rVar6 = this.aZn.aZm;
            rVar5.sendMessage(rVar6.Oj());
        }
    }
}
