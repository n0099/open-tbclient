package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public w(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePassFriendMessage)) {
            ResponsePassFriendMessage responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage;
            int error = responsePassFriendMessage.getError();
            long friendId = responsePassFriendMessage.getFriendId();
            String name = responsePassFriendMessage.getName();
            String portrait = responsePassFriendMessage.getPortrait();
            String key = responsePassFriendMessage.getKey();
            String quanpin = responsePassFriendMessage.getQuanpin();
            com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
            eVar.setId(friendId);
            eVar.setStatus(2);
            eVar.fw(0);
            if (error == 0) {
                com.baidu.tieba.im.e.a(new x(this, friendId, eVar), new y(this, friendId, portrait, name, key, quanpin));
            } else if (error == 3100098) {
                Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestPassFriendMessage) {
                    long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                    com.baidu.tieba.im.e.a(new z(this, friendId2), new aa(this, friendId2));
                }
            }
        }
    }
}
