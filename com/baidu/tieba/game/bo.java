package com.baidu.tieba.game;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bn aJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(bn bnVar, int i, int i2) {
        super(i, i2);
        this.aJl = bnVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        if (!(responsedMessage instanceof ResponseMutilGameHttpMessage) && !(responsedMessage instanceof ResponseMutilGameSocketMessage)) {
            bqVar8 = this.aJl.aJe;
            if (bqVar8 != null) {
                bqVar9 = this.aJl.aJe;
                bqVar9.fw(null);
            }
        } else if (responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() != this.aJl.getUniqueId()) {
            bqVar6 = this.aJl.aJe;
            if (bqVar6 != null) {
                bqVar7 = this.aJl.aJe;
                bqVar7.fw(null);
            }
        } else if (responsedMessage.getError() != 0) {
            bqVar4 = this.aJl.aJe;
            if (bqVar4 != null) {
                bqVar5 = this.aJl.aJe;
                bqVar5.fw(responsedMessage.getErrorString());
            }
        } else {
            bqVar = this.aJl.aJe;
            if (bqVar != null) {
                if (responsedMessage instanceof ResponseMutilGameSocketMessage) {
                    bqVar3 = this.aJl.aJe;
                    bqVar3.b(((ResponseMutilGameSocketMessage) responsedMessage).getData());
                } else if (responsedMessage instanceof ResponseMutilGameHttpMessage) {
                    bqVar2 = this.aJl.aJe;
                    bqVar2.b(((ResponseMutilGameHttpMessage) responsedMessage).getData());
                }
            }
        }
    }
}
