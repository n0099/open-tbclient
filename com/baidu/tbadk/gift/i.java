package com.baidu.tbadk.gift;

import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ BuyGiftActivity aaD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(BuyGiftActivity buyGiftActivity, int i) {
        super(i);
        this.aaD = buyGiftActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        TextView textView;
        if (socketResponsedMessage instanceof SendGiftSocketResponseMessage) {
            textView = this.aaD.aab;
            textView.setEnabled(true);
            SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) socketResponsedMessage;
            this.aaD.a(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
        }
    }
}
