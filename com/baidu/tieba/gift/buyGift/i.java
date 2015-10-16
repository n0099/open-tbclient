package com.baidu.tieba.gift.buyGift;

import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ BuyGiftActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(BuyGiftActivity buyGiftActivity, int i, int i2) {
        super(i, i2);
        this.bmC = buyGiftActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        TextView textView;
        TextView textView2;
        if (responsedMessage instanceof SendGiftSocketResponseMessage) {
            textView2 = this.bmC.bmb;
            textView2.setEnabled(true);
            SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
            this.bmC.a(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
        } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
            textView = this.bmC.bmb;
            textView.setEnabled(true);
            SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
            this.bmC.a(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
        }
    }
}
