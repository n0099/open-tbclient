package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
/* loaded from: classes.dex */
class y extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ OfficialBarChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.a = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        officialBarMsglistView = this.a.m;
        officialBarMsglistView.d(false);
        if (!(socketResponsedMessage instanceof ResponseSendOfficialBarMenuMessage)) {
            this.a.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseSendOfficialBarMenuMessage responseSendOfficialBarMenuMessage = (ResponseSendOfficialBarMenuMessage) socketResponsedMessage;
        if (responseSendOfficialBarMenuMessage.hasError()) {
            if (responseSendOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseSendOfficialBarMenuMessage.getErrorString())) {
                this.a.showToast(responseSendOfficialBarMenuMessage.getErrorString());
            } else {
                this.a.showToast(com.baidu.tieba.y.neterror);
            }
        }
    }
}
