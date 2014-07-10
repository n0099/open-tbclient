package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedLocalMessage;
import com.baidu.tieba.model.aa;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.a = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        aa aaVar;
        com.baidu.tieba.data.s friendFeedData;
        aa aaVar2;
        this.a.a(true);
        tVar = this.a.c;
        l c = tVar.c();
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseFriendFeedLocalMessage)) {
            ResponseFriendFeedLocalMessage responseFriendFeedLocalMessage = (ResponseFriendFeedLocalMessage) customResponsedMessage;
            aaVar = this.a.d;
            if (!aaVar.b() && (friendFeedData = responseFriendFeedLocalMessage.getFriendFeedData()) != null) {
                aaVar2 = this.a.d;
                aaVar2.a(true);
                c.a(friendFeedData);
                c.notifyDataSetChanged();
            }
        }
    }
}
