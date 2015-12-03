package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.gift.giftTab.a;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a buV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.buV = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        ArrayList<com.baidu.tbadk.core.data.l> arrayList;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof CategoryGiftListHttpResponseMessage) || (responsedMessage instanceof CategoryGiftListSocketResponseMessage)) {
                int i = 0;
                if (responsedMessage instanceof CategoryGiftListHttpResponseMessage) {
                    CategoryGiftListHttpResponseMessage categoryGiftListHttpResponseMessage = (CategoryGiftListHttpResponseMessage) responsedMessage;
                    this.buV.giftList = categoryGiftListHttpResponseMessage.getGiftList();
                    i = categoryGiftListHttpResponseMessage.getCategoryId();
                } else if (responsedMessage instanceof CategoryGiftListSocketResponseMessage) {
                    CategoryGiftListSocketResponseMessage categoryGiftListSocketResponseMessage = (CategoryGiftListSocketResponseMessage) responsedMessage;
                    this.buV.giftList = categoryGiftListSocketResponseMessage.getGiftList();
                    i = categoryGiftListSocketResponseMessage.getCategoryId();
                }
                interfaceC0062a = this.buV.buU;
                if (interfaceC0062a != null) {
                    interfaceC0062a2 = this.buV.buU;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    arrayList = this.buV.giftList;
                    interfaceC0062a2.a(error, errorString, i, arrayList);
                }
            }
        }
    }
}
