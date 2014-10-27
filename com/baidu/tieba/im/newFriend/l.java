package com.baidu.tieba.im.newFriend;

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
            com.baidu.tbadk.newFriends.a.un().a(id, content, requestNewFriendActionLocalMessage.getSt_type());
            com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
            eVar.setId(id);
            eVar.setName(name);
            eVar.setStatus(0);
            eVar.setPortrait(portrait);
            eVar.setContent(content);
            eVar.fw(0);
            com.baidu.tieba.im.e.a(new m(this, id, eVar), null);
        }
    }
}
