package com.baidu.tieba.gift.send;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.gift.send.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b bxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i, int i2) {
        super(i, i2);
        this.bxs = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        b.a aVar;
        b.a aVar2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof PlaceOrderHttpResponse) || (responsedMessage instanceof PlaceOrderSocketResponse)) {
                a aVar3 = null;
                if (responsedMessage instanceof PlaceOrderHttpResponse) {
                    aVar3 = ((PlaceOrderHttpResponse) responsedMessage).getOrderInfo();
                } else if (responsedMessage instanceof PlaceOrderSocketResponse) {
                    aVar3 = ((PlaceOrderSocketResponse) responsedMessage).getOrderInfo();
                }
                aVar = this.bxs.bxp;
                if (aVar != null) {
                    aVar2 = this.bxs.bxp;
                    aVar2.a(responsedMessage.getError(), responsedMessage.getErrorString(), aVar3);
                }
            }
        }
    }
}
