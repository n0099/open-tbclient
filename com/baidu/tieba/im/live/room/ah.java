package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseIncrLiveGroupLikeMessage;
/* loaded from: classes.dex */
class ah extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LiveRoomChatView x;
        LiveRoomChatView x2;
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage.getCmd() == 107108 && (socketResponsedMessage instanceof ResponseIncrLiveGroupLikeMessage)) {
            ResponseIncrLiveGroupLikeMessage responseIncrLiveGroupLikeMessage = (ResponseIncrLiveGroupLikeMessage) socketResponsedMessage;
            if (responseIncrLiveGroupLikeMessage.mLiveGroupInfo != null && this.a.v().b != null && this.a.v().b.groupId.equals(responseIncrLiveGroupLikeMessage.mLiveGroupInfo.groupId)) {
                if (responseIncrLiveGroupLikeMessage.hasError()) {
                    if (!TextUtils.isEmpty(responseIncrLiveGroupLikeMessage.getErrorString())) {
                        this.a.showToast(responseIncrLiveGroupLikeMessage.getErrorString());
                    }
                    this.a.v().g = responseIncrLiveGroupLikeMessage.mType != 1 ? 2 : 1;
                    x2 = this.a.x();
                    x2.a(this.a.v().d, this.a.v().i, this.a.v().g);
                    return;
                }
                this.a.v().g = responseIncrLiveGroupLikeMessage.mType != 1 ? 2 : 1;
                x = this.a.x();
                x.a(this.a.v().d, this.a.v().i, this.a.v().g);
            }
        }
    }
}
