package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LivePublisherSayMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveRoomChatView liveRoomChatView;
        LiveRoomChatView liveRoomChatView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003170 && (customResponsedMessage instanceof LivePublisherSayMessage) && this.a.x() != null && this.a.x().b != null) {
            liveRoomChatView = this.a.p;
            if (liveRoomChatView != null) {
                LivePublisherSayMessage livePublisherSayMessage = (LivePublisherSayMessage) customResponsedMessage;
                if (livePublisherSayMessage.getChatMsg() != null && (livePublisherSayMessage.getChatMsg() instanceof ChatMessage)) {
                    ChatMessage chatMessage = (ChatMessage) livePublisherSayMessage.getChatMsg();
                    if (com.baidu.adp.lib.f.b.a(chatMessage.getGroupId(), 0) == this.a.x().b.groupId.intValue()) {
                        liveRoomChatView2 = this.a.p;
                        liveRoomChatView2.a(chatMessage);
                    }
                }
            }
        }
    }
}
