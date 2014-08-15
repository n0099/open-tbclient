package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
/* loaded from: classes.dex */
class p extends com.baidu.adp.framework.listener.d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            long friendId = responseDeleteFriendMessage.getFriendId();
            if (error == 0) {
                com.baidu.tieba.im.e.a(new q(this, friendId), new r(this, friendId));
            }
        }
    }
}
