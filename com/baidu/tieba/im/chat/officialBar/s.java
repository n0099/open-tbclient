package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
/* loaded from: classes.dex */
class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aZk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aZk = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        officialBarMsglistView = this.aZk.aZe;
        officialBarMsglistView.ct(false);
        if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
            this.aZk.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
        if (responseSendOfficialBarMenuMessage.hasError()) {
            if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                this.aZk.showToast(StringUtils.isNull(responseSendOfficialBarMenuMessage.getErrorString()) ? this.aZk.getResources().getString(com.baidu.tieba.y.neterror) : responseSendOfficialBarMenuMessage.getErrorString());
            } else {
                this.aZk.showToast(com.baidu.tieba.y.neterror);
            }
        }
    }
}
