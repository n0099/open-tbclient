package com.baidu.tieba.home;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f aMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.aMo = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.model.n nVar;
        r rVar;
        com.baidu.tieba.model.n nVar2;
        com.baidu.tieba.model.n nVar3;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            nVar = this.aMo.aMf;
            if (nVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                rVar = this.aMo.aMd;
                rVar.IN();
                if (!responsedMessage.hasError()) {
                    if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                        nVar3 = this.aMo.aMf;
                        nVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        nVar2 = this.aMo.aMf;
                        nVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }
}
