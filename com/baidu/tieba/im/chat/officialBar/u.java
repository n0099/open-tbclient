package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
/* loaded from: classes.dex */
class u extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aUp = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        officialBarMsglistView = this.aUp.aUi;
        officialBarMsglistView.cA(false);
        if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
            this.aUp.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
        if (responseSendOfficialBarMenuMessage.hasError()) {
            if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                this.aUp.showToast(responseSendOfficialBarMenuMessage.getErrorString());
            } else {
                this.aUp.showToast(com.baidu.tieba.z.neterror);
            }
        }
    }
}
