package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.RequestLiveGroupOwnerGagMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupOwnerGagMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.a.hideProgressBar();
        if (!(socketResponsedMessage instanceof ResponseLiveGroupOwnerGagMessage)) {
            this.a.showToast(com.baidu.tieba.x.neterror);
            return;
        }
        ResponseLiveGroupOwnerGagMessage responseLiveGroupOwnerGagMessage = (ResponseLiveGroupOwnerGagMessage) socketResponsedMessage;
        if (responseLiveGroupOwnerGagMessage.hasError()) {
            if (responseLiveGroupOwnerGagMessage.getError() > 0 && !TextUtils.isEmpty(responseLiveGroupOwnerGagMessage.getErrorString())) {
                this.a.showToast(responseLiveGroupOwnerGagMessage.getErrorString());
                return;
            } else {
                this.a.showToast(com.baidu.tieba.x.neterror);
                return;
            }
        }
        Message<?> orginalMessage = responseLiveGroupOwnerGagMessage.getOrginalMessage();
        if (orginalMessage instanceof RequestLiveGroupOwnerGagMessage) {
            RequestLiveGroupOwnerGagMessage requestLiveGroupOwnerGagMessage = (RequestLiveGroupOwnerGagMessage) orginalMessage;
            if (requestLiveGroupOwnerGagMessage.getType() == 1) {
                String userNames = requestLiveGroupOwnerGagMessage.getUserNames();
                if (!TextUtils.isEmpty(userNames)) {
                    this.a.showToast(String.valueOf(userNames) + this.a.getString(com.baidu.tieba.x.live_chat_room_mute_success));
                } else {
                    this.a.showToast(com.baidu.tieba.x.live_chat_room_mute_success);
                }
            }
        }
    }
}
