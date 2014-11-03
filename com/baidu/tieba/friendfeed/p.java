package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedLocalMessage;
import com.baidu.tieba.model.ac;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.ayU = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        ac acVar;
        com.baidu.tieba.data.s friendFeedData;
        ac acVar2;
        this.ayU.bK(true);
        yVar = this.ayU.ayz;
        q ES = yVar.ES();
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseFriendFeedLocalMessage)) {
            ResponseFriendFeedLocalMessage responseFriendFeedLocalMessage = (ResponseFriendFeedLocalMessage) customResponsedMessage;
            acVar = this.ayU.ayA;
            if (!acVar.isUseCache() && (friendFeedData = responseFriendFeedLocalMessage.getFriendFeedData()) != null) {
                acVar2 = this.ayU.ayA;
                acVar2.setUseCache(true);
                ES.a(friendFeedData);
                ES.notifyDataSetChanged();
            }
        }
    }
}
