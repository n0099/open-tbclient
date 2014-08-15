package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* loaded from: classes.dex */
class an extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(NewFriendsActivity newFriendsActivity, int i) {
        super(i);
        this.a = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponsePassFriendMessage responsePassFriendMessage;
        int error;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
            this.a.showToast(responsePassFriendMessage.getErrorString());
        }
    }
}
