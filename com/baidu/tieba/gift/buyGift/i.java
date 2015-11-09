package com.baidu.tieba.gift.buyGift;

import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(BuyGiftActivity buyGiftActivity, int i, int i2) {
        super(i, i2);
        this.bng = buyGiftActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        TextView textView;
        TextView textView2;
        if (responsedMessage instanceof SendGiftSocketResponseMessage) {
            textView2 = this.bng.bmF;
            textView2.setEnabled(true);
            SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
            this.bng.a(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
        } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
            textView = this.bng.bmF;
            textView.setEnabled(true);
            SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
            this.bng.a(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
        }
    }
}
