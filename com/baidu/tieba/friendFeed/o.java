package com.baidu.tieba.friendFeed;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.friendFeed.message.ResponseFriendFeedLocalMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aHU = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        com.baidu.tieba.friendFeed.a.a aVar;
        com.baidu.tieba.friendFeed.data.a friendFeedData;
        com.baidu.tieba.friendFeed.a.a aVar2;
        this.aHU.sendMessage(true);
        yVar = this.aHU.aHB;
        p Jh = yVar.Jh();
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseFriendFeedLocalMessage)) {
            ResponseFriendFeedLocalMessage responseFriendFeedLocalMessage = (ResponseFriendFeedLocalMessage) customResponsedMessage;
            aVar = this.aHU.aHC;
            if (!aVar.isUseCache() && (friendFeedData = responseFriendFeedLocalMessage.getFriendFeedData()) != null) {
                aVar2 = this.aHU.aHC;
                aVar2.setUseCache(true);
                Jh.a(friendFeedData);
                Jh.notifyDataSetChanged();
            }
        }
    }
}
