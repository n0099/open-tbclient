package com.baidu.tbadk.gift;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class h extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ BuyGiftActivity abe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(BuyGiftActivity buyGiftActivity, int i) {
        super(i);
        this.abe = buyGiftActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof GetGiftCommonListSocketResponseMessage) {
            GetGiftCommonListSocketResponseMessage getGiftCommonListSocketResponseMessage = (GetGiftCommonListSocketResponseMessage) socketResponsedMessage;
            this.abe.aaN = getGiftCommonListSocketResponseMessage.getGiftInfo();
            this.abe.p(getGiftCommonListSocketResponseMessage.getError(), getGiftCommonListSocketResponseMessage.getErrorString());
        }
    }
}
