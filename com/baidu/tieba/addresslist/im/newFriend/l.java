package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001173) {
            RequestNewFriendActionLocalMessage requestNewFriendActionLocalMessage = (RequestNewFriendActionLocalMessage) customResponsedMessage;
            long id = requestNewFriendActionLocalMessage.getId();
            String name = requestNewFriendActionLocalMessage.getName();
            String portrait = requestNewFriendActionLocalMessage.getPortrait();
            String content = requestNewFriendActionLocalMessage.getContent();
            com.baidu.tbadk.newFriends.a.CR().a(id, content, requestNewFriendActionLocalMessage.getSt_type());
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(id);
            bVar.setName(name);
            bVar.setStatus(0);
            bVar.setPortrait(portrait);
            bVar.setContent(content);
            bVar.fY(0);
            com.baidu.tieba.im.l.a(new m(this, id, bVar), null);
        }
    }
}
