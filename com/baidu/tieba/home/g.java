package com.baidu.tieba.home;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.aPP = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.model.d dVar;
        r rVar;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        r rVar2;
        r rVar3;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            dVar = this.aPP.aPD;
            if (dVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                rVar = this.aPP.aPB;
                rVar.JI();
                if (responsedMessage.hasError()) {
                    rVar2 = this.aPP.aPB;
                    if (rVar2.JZ().JH() == null) {
                        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
                        rVar3 = this.aPP.aPB;
                        rVar3.b(eVar);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    dVar3 = this.aPP.aPD;
                    dVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    dVar2 = this.aPP.aPD;
                    dVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
