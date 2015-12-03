package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.gift.giftTab.d;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d buZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.buZ = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        int i;
        String str;
        ArrayList<c> arrayList;
        ArrayList<com.baidu.tbadk.core.data.l> arrayList2;
        ArrayList<k> arrayList3;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof DefaultGiftListHttpResponseMessage) || (responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                if (responsedMessage instanceof DefaultGiftListHttpResponseMessage) {
                    DefaultGiftListHttpResponseMessage defaultGiftListHttpResponseMessage = (DefaultGiftListHttpResponseMessage) responsedMessage;
                    this.buZ.categoryList = defaultGiftListHttpResponseMessage.getCategoryList();
                    this.buZ.giftList = defaultGiftListHttpResponseMessage.getGiftList();
                    this.buZ.numberList = defaultGiftListHttpResponseMessage.getGiftNumberList();
                    this.buZ.addFreeUrl = defaultGiftListHttpResponseMessage.getAddFreeUrl();
                    this.buZ.freeChance = defaultGiftListHttpResponseMessage.getFreeChance();
                } else if (responsedMessage instanceof DefaultGiftListSocketResponseMessage) {
                    DefaultGiftListSocketResponseMessage defaultGiftListSocketResponseMessage = (DefaultGiftListSocketResponseMessage) responsedMessage;
                    this.buZ.categoryList = defaultGiftListSocketResponseMessage.getCategoryList();
                    this.buZ.giftList = defaultGiftListSocketResponseMessage.getGiftList();
                    this.buZ.numberList = defaultGiftListSocketResponseMessage.getGiftNumberList();
                    this.buZ.addFreeUrl = defaultGiftListSocketResponseMessage.getAddFreeUrl();
                    this.buZ.freeChance = defaultGiftListSocketResponseMessage.getFreeChance();
                }
                aVar = this.buZ.buY;
                if (aVar != null) {
                    aVar2 = this.buZ.buY;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    i = this.buZ.freeChance;
                    str = this.buZ.addFreeUrl;
                    arrayList = this.buZ.categoryList;
                    arrayList2 = this.buZ.giftList;
                    arrayList3 = this.buZ.numberList;
                    aVar2.a(error, errorString, i, str, arrayList, arrayList2, arrayList3);
                }
            }
        }
    }
}
