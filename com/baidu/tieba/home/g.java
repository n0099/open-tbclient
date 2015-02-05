package com.baidu.tieba.home;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f aPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.aPO = fVar;
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
            dVar = this.aPO.aPC;
            if (dVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                rVar = this.aPO.aPA;
                rVar.JD();
                if (responsedMessage.hasError()) {
                    rVar2 = this.aPO.aPA;
                    if (rVar2.JU().JC() == null) {
                        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
                        rVar3 = this.aPO.aPA;
                        rVar3.b(eVar);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    dVar3 = this.aPO.aPC;
                    dVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    dVar2 = this.aPO.aPC;
                    dVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
