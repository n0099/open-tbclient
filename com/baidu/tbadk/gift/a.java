package com.baidu.tbadk.gift;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ BuyGiftActivity Uy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BuyGiftActivity buyGiftActivity, int i) {
        super(i);
        this.Uy = buyGiftActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof GetGiftCommonListHttpResponseMessage) {
            GetGiftCommonListHttpResponseMessage getGiftCommonListHttpResponseMessage = (GetGiftCommonListHttpResponseMessage) httpResponsedMessage;
            this.Uy.Uh = getGiftCommonListHttpResponseMessage.getGiftInfo();
            this.Uy.g(getGiftCommonListHttpResponseMessage.getError(), getGiftCommonListHttpResponseMessage.getErrorString());
        }
    }
}
