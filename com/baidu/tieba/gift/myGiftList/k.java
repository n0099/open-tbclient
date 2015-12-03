package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.gift.myGiftList.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ j bwM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, int i, int i2) {
        super(i, i2);
        this.bwM = jVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        j.a aVar;
        j.a aVar2;
        boolean z;
        a aVar3;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof GetPersonalGiftListHttpResponseMessage) || (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (!(responsedMessage instanceof GetPersonalGiftListHttpResponseMessage)) {
                        if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                            this.bwM.a(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                        }
                    } else {
                        this.bwM.a(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                    }
                }
                aVar = this.bwM.bwL;
                if (aVar != null) {
                    aVar2 = this.bwM.bwL;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    z = this.bwM.aWG;
                    aVar3 = this.bwM.bwK;
                    aVar2.a(error, errorString, z, aVar3);
                }
                this.bwM.aWG = false;
            }
        }
    }
}
