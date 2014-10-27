package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
/* loaded from: classes.dex */
class u extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aRf = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        officialBarMsglistView = this.aRf.aQY;
        officialBarMsglistView.cJ(false);
        if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
            this.aRf.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
        if (responseSendOfficialBarMenuMessage.hasError()) {
            if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                this.aRf.showToast(responseSendOfficialBarMenuMessage.getErrorString());
            } else {
                this.aRf.showToast(com.baidu.tieba.y.neterror);
            }
        }
    }
}
