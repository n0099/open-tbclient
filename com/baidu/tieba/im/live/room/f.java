package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Message<?> orginalMessage;
        RequestRemoveMembersMessage requestRemoveMembersMessage;
        RequestRemoveMembersMessage requestRemoveMembersMessage2;
        this.a.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage.getCmd() == 103112 && (socketResponsedMessage instanceof ResponseRemoveMembersMessage) && (orginalMessage = socketResponsedMessage.getOrginalMessage()) != null) {
            requestRemoveMembersMessage = this.a.w;
            if (orginalMessage.equals(requestRemoveMembersMessage)) {
                requestRemoveMembersMessage2 = this.a.w;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001201, Long.valueOf(requestRemoveMembersMessage2.getGroupId())));
                this.a.finish();
            }
        }
    }
}
