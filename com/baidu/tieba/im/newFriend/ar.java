package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* loaded from: classes.dex */
class ar extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NewFriendsActivity bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(NewFriendsActivity newFriendsActivity, int i) {
        super(i);
        this.bhm = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponsePassFriendMessage responsePassFriendMessage;
        int error;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
            this.bhm.showToast(com.baidu.tieba.y.neterror);
        } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
            this.bhm.showToast(responsePassFriendMessage.getErrorString());
        }
    }
}
