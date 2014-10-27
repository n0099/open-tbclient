package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ GroupActivityActivity aZa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupActivityActivity groupActivityActivity, int i) {
        super(i);
        this.aZa = groupActivityActivity;
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
            rVar7 = this.aZa.aYZ;
            rVar8 = this.aZa.aYZ;
            rVar7.sendMessage(rVar8.Og());
            return;
        }
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage;
        rVar = this.aZa.aYZ;
        if (rVar.getLocalSendMsg() == responseGetGroupActivityLocalMessage.getOrginalMessage()) {
            if (responseGetGroupActivityLocalMessage.getError() == 0) {
                sVar = this.aZa.aYY;
                sVar.a(responseGetGroupActivityLocalMessage.getActivityData(), true);
                rVar2 = this.aZa.aYZ;
                rVar2.a(responseGetGroupActivityLocalMessage.getActivityData());
                rVar3 = this.aZa.aYZ;
                rVar4 = this.aZa.aYZ;
                rVar3.sendMessage(rVar4.Og());
                return;
            }
            rVar5 = this.aZa.aYZ;
            rVar6 = this.aZa.aYZ;
            rVar5.sendMessage(rVar6.Og());
        }
    }
}
