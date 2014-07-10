package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
            ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
            int error = responseAddFriendMessage.getError();
            long friendId = responseAddFriendMessage.getFriendId();
            com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
            kVar.a(friendId);
            kVar.b(0);
            if (error == 0) {
                kVar.a(3);
                com.baidu.tieba.im.i.a(new f(this, kVar), new g(this));
            } else if (error == 3100097) {
                Message<?> orginalMessage = responseAddFriendMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestAddFriendMessage) {
                    long friendId2 = ((RequestAddFriendMessage) orginalMessage).getFriendId();
                    com.baidu.tieba.im.i.a(new h(this, friendId2), new i(this, friendId2));
                }
            }
        }
    }
}
