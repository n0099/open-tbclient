package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.model.ab;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class g extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.a = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        t tVar;
        boolean k;
        ab abVar;
        boolean k2;
        t tVar2;
        tVar = this.a.c;
        l c = tVar.c();
        this.a.j();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.a.showToast(x.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.a.showToast(responseFriendFeedMessage.getErrorString());
                return;
            } else {
                this.a.showToast(x.neterror);
                return;
            }
        }
        com.baidu.tieba.data.s friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            k = this.a.k();
            if (k) {
                c.b(true);
            }
            c.d(friendFeedData.c());
            if (!friendFeedData.c()) {
                k2 = this.a.k();
                if (k2 && friendFeedData.b().size() == 0) {
                    tVar2 = this.a.c;
                    tVar2.a(true);
                    return;
                }
            }
            c.c(true);
            c.a(friendFeedData);
            abVar = this.a.d;
            abVar.a(c.c());
            c.notifyDataSetChanged();
        }
    }
}
