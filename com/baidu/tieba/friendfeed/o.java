package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedLocalMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aBS = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        x xVar;
        com.baidu.tieba.model.l lVar;
        com.baidu.tieba.data.i friendFeedData;
        com.baidu.tieba.model.l lVar2;
        this.aBS.sendMessage(true);
        xVar = this.aBS.aBA;
        p FC = xVar.FC();
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseFriendFeedLocalMessage)) {
            ResponseFriendFeedLocalMessage responseFriendFeedLocalMessage = (ResponseFriendFeedLocalMessage) customResponsedMessage;
            lVar = this.aBS.aBB;
            if (!lVar.UF() && (friendFeedData = responseFriendFeedLocalMessage.getFriendFeedData()) != null) {
                lVar2 = this.aBS.aBB;
                lVar2.setUseCache(true);
                FC.a(friendFeedData);
                FC.notifyDataSetChanged();
            }
        }
    }
}
