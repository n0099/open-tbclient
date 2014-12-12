package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedLocalMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aAU = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        com.baidu.tieba.model.l lVar;
        com.baidu.tieba.data.i friendFeedData;
        com.baidu.tieba.model.l lVar2;
        this.aAU.sendMessage(true);
        yVar = this.aAU.aAB;
        q Fk = yVar.Fk();
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseFriendFeedLocalMessage)) {
            ResponseFriendFeedLocalMessage responseFriendFeedLocalMessage = (ResponseFriendFeedLocalMessage) customResponsedMessage;
            lVar = this.aAU.aAC;
            if (!lVar.isUseCache() && (friendFeedData = responseFriendFeedLocalMessage.getFriendFeedData()) != null) {
                lVar2 = this.aAU.aAC;
                lVar2.setUseCache(true);
                Fk.a(friendFeedData);
                Fk.notifyDataSetChanged();
            }
        }
    }
}
