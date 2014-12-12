package com.baidu.tieba.home;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f aOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.aOG = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.model.d dVar;
        s sVar;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            dVar = this.aOG.aOu;
            if (dVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                sVar = this.aOG.aOs;
                sVar.Jm();
                if (!responsedMessage.hasError()) {
                    if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                        dVar3 = this.aOG.aOu;
                        dVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        dVar2 = this.aOG.aOu;
                        dVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }
}
