package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ o a;
    private final /* synthetic */ RequestAddFriendMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, RequestAddFriendMessage requestAddFriendMessage) {
        this.a = oVar;
        this.b = requestAddFriendMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r9) {
        ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", "");
        responseNewFriendUpdateUiMsg.setContent(this.b.getMessage());
        MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
    }
}
