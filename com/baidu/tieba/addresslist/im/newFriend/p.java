package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
            ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
            RequestAddFriendMessage requestAddFriendMessage = (RequestAddFriendMessage) responseAddFriendMessage.getOrginalMessage();
            int error = responseAddFriendMessage.getError();
            long friendId = responseAddFriendMessage.getFriendId();
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(friendId);
            bVar.fY(0);
            bVar.setContent(requestAddFriendMessage.getMessage());
            if (error == 0) {
                bVar.setStatus(3);
                com.baidu.tieba.im.l.a(new q(this, friendId, bVar), new r(this, friendId, requestAddFriendMessage));
            } else if (error == 3100097) {
                Message<?> orginalMessage = responseAddFriendMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestAddFriendMessage) {
                    long friendId2 = ((RequestAddFriendMessage) orginalMessage).getFriendId();
                    com.baidu.tieba.im.l.a(new s(this, friendId2), new t(this, friendId2));
                }
            }
        }
    }
}
