package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseSubscribeLiveGroupMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.b {
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
        LiveRoomChatView z;
        LiveRoomChatView z2;
        LiveRoomChatView z3;
        LiveRoomChatView z4;
        LiveRoomChatView z5;
        if (socketResponsedMessage.getCmd() != 107105) {
            z5 = this.a.z();
            z5.g(false);
        } else if (!(socketResponsedMessage instanceof ResponseSubscribeLiveGroupMessage)) {
            z4 = this.a.z();
            z4.g(false);
            this.a.showToast(com.baidu.tieba.u.neterror);
        } else {
            ResponseSubscribeLiveGroupMessage responseSubscribeLiveGroupMessage = (ResponseSubscribeLiveGroupMessage) socketResponsedMessage;
            if (responseSubscribeLiveGroupMessage.getError() != 0) {
                z3 = this.a.z();
                z3.g(false);
                if (responseSubscribeLiveGroupMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseSubscribeLiveGroupMessage.getErrorString())) {
                        this.a.showToast(responseSubscribeLiveGroupMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.a.showToast(com.baidu.tieba.u.neterror);
            } else if (this.a.x().f) {
                this.a.x().f = false;
                z2 = this.a.z();
                z2.g(false);
                this.a.showToast(com.baidu.tieba.u.live_room_cancel_attention);
            } else {
                this.a.x().f = true;
                z = this.a.z();
                z.g(true);
                this.a.showToast(com.baidu.tieba.u.live_room_attentioned);
            }
        }
    }
}
