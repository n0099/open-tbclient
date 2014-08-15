package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.framework.listener.d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePassFriendMessage)) {
            ResponsePassFriendMessage responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage;
            int error = responsePassFriendMessage.getError();
            long friendId = responsePassFriendMessage.getFriendId();
            String name = responsePassFriendMessage.getName();
            String portrait = responsePassFriendMessage.getPortrait();
            String key = responsePassFriendMessage.getKey();
            String quanpin = responsePassFriendMessage.getQuanpin();
            com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
            kVar.a(friendId);
            kVar.a(2);
            kVar.b(0);
            if (error == 0) {
                com.baidu.tieba.im.e.a(new t(this, friendId, kVar), new u(this, friendId, portrait, name, key, quanpin));
            } else if (error == 3100098) {
                Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestPassFriendMessage) {
                    long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                    com.baidu.tieba.im.e.a(new v(this, friendId2), new w(this, friendId2));
                }
            }
        }
    }
}
