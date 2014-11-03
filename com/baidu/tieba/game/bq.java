package com.baidu.tieba.game;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bp aJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(bp bpVar, int i, int i2) {
        super(i, i2);
        this.aJy = bpVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        if (!(responsedMessage instanceof ResponseMutilGameHttpMessage) && !(responsedMessage instanceof ResponseMutilGameSocketMessage)) {
            bsVar8 = this.aJy.aJr;
            if (bsVar8 != null) {
                bsVar9 = this.aJy.aJr;
                bsVar9.fw(null);
            }
        } else if (responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() != this.aJy.getUniqueId()) {
            bsVar6 = this.aJy.aJr;
            if (bsVar6 != null) {
                bsVar7 = this.aJy.aJr;
                bsVar7.fw(null);
            }
        } else if (responsedMessage.getError() != 0) {
            bsVar4 = this.aJy.aJr;
            if (bsVar4 != null) {
                bsVar5 = this.aJy.aJr;
                bsVar5.fw(responsedMessage.getErrorString());
            }
        } else {
            bsVar = this.aJy.aJr;
            if (bsVar != null) {
                if (responsedMessage instanceof ResponseMutilGameSocketMessage) {
                    bsVar3 = this.aJy.aJr;
                    bsVar3.b(((ResponseMutilGameSocketMessage) responsedMessage).getData());
                } else if (responsedMessage instanceof ResponseMutilGameHttpMessage) {
                    bsVar2 = this.aJy.aJr;
                    bsVar2.b(((ResponseMutilGameHttpMessage) responsedMessage).getData());
                }
            }
        }
    }
}
