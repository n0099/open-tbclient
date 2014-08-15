package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ k a;
    private final /* synthetic */ RequestAddFriendMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, RequestAddFriendMessage requestAddFriendMessage) {
        this.a = kVar;
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
