package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.gift.giftTab.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f bvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.bvb = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        f.a aVar;
        f.a aVar2;
        int i;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof FreeGiftChanceHttpResponseMessage) || (responsedMessage instanceof FreeGiftChanceSocketResponseMessage)) {
                if (responsedMessage instanceof FreeGiftChanceHttpResponseMessage) {
                    this.bvb.freeChance = ((FreeGiftChanceHttpResponseMessage) responsedMessage).getFreeChance();
                } else if (responsedMessage instanceof FreeGiftChanceSocketResponseMessage) {
                    this.bvb.freeChance = ((FreeGiftChanceSocketResponseMessage) responsedMessage).getFreeChance();
                }
                aVar = this.bvb.bva;
                if (aVar != null) {
                    aVar2 = this.bvb.bva;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    i = this.bvb.freeChance;
                    aVar2.b(error, errorString, i);
                }
            }
        }
    }
}
