package com.baidu.tbadk.gift;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ BuyGiftActivity aaD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(BuyGiftActivity buyGiftActivity, int i) {
        super(i);
        this.aaD = buyGiftActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.aaD.aas = true;
        this.aaD.vG();
    }
}
