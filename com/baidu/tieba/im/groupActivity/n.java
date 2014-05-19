package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ GroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupActivityActivity groupActivityActivity, int i) {
        super(i);
        this.a = groupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
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
            rVar7 = this.a.b;
            rVar8 = this.a.b;
            rVar7.c(rVar8.b());
            return;
        }
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage;
        rVar = this.a.b;
        if (rVar.d() == responseGetGroupActivityLocalMessage.getOrginalMessage()) {
            if (responseGetGroupActivityLocalMessage.getError() == 0) {
                sVar = this.a.a;
                sVar.a(responseGetGroupActivityLocalMessage.getActivityData(), true);
                rVar2 = this.a.b;
                rVar2.a(responseGetGroupActivityLocalMessage.getActivityData());
                rVar3 = this.a.b;
                rVar4 = this.a.b;
                rVar3.c(rVar4.b());
                return;
            }
            rVar5 = this.a.b;
            rVar6 = this.a.b;
            rVar5.c(rVar6.b());
        }
    }
}
