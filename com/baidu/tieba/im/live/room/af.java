package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseIncrLiveGroupLikeMessage;
/* loaded from: classes.dex */
class af extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LiveRoomChatView z;
        LiveRoomChatView z2;
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107108 && (socketResponsedMessage instanceof ResponseIncrLiveGroupLikeMessage)) {
            ResponseIncrLiveGroupLikeMessage responseIncrLiveGroupLikeMessage = (ResponseIncrLiveGroupLikeMessage) socketResponsedMessage;
            if (responseIncrLiveGroupLikeMessage.mLiveGroupInfo != null && this.a.x().b != null && this.a.x().b.groupId.equals(responseIncrLiveGroupLikeMessage.mLiveGroupInfo.groupId)) {
                if (responseIncrLiveGroupLikeMessage.hasError()) {
                    if (!TextUtils.isEmpty(responseIncrLiveGroupLikeMessage.getErrorString())) {
                        this.a.showToast(responseIncrLiveGroupLikeMessage.getErrorString());
                    }
                    this.a.x().g = responseIncrLiveGroupLikeMessage.mType != 1 ? 2 : 1;
                    z2 = this.a.z();
                    z2.a(this.a.x().d, this.a.x().i, this.a.x().g);
                    return;
                }
                this.a.x().g = responseIncrLiveGroupLikeMessage.mType != 1 ? 2 : 1;
                z = this.a.z();
                z.a(this.a.x().d, this.a.x().i, this.a.x().g);
            }
        }
    }
}
