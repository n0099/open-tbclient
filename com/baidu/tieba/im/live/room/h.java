package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseSubscribeLiveGroupMessage;
/* loaded from: classes.dex */
class h extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LiveRoomChatView x;
        LiveRoomChatView x2;
        LiveRoomChatView x3;
        LiveRoomChatView x4;
        LiveRoomChatView x5;
        if (socketResponsedMessage.getCmd() != 107105) {
            x5 = this.a.x();
            x5.g(false);
        } else if (!(socketResponsedMessage instanceof ResponseSubscribeLiveGroupMessage)) {
            x4 = this.a.x();
            x4.g(false);
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else {
            ResponseSubscribeLiveGroupMessage responseSubscribeLiveGroupMessage = (ResponseSubscribeLiveGroupMessage) socketResponsedMessage;
            if (responseSubscribeLiveGroupMessage.getError() != 0) {
                x3 = this.a.x();
                x3.g(false);
                if (responseSubscribeLiveGroupMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseSubscribeLiveGroupMessage.getErrorString())) {
                        this.a.showToast(responseSubscribeLiveGroupMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.a.showToast(com.baidu.tieba.x.neterror);
            } else if (this.a.v().f) {
                this.a.v().f = false;
                x2 = this.a.x();
                x2.g(false);
                this.a.showToast(com.baidu.tieba.x.live_room_cancel_attention);
            } else {
                this.a.v().f = true;
                x = this.a.x();
                x.g(true);
                this.a.showToast(com.baidu.tieba.x.live_room_attentioned);
            }
        }
    }
}
