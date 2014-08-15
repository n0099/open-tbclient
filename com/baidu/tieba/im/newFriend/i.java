package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001173) {
            RequestNewFriendActionLocalMessage requestNewFriendActionLocalMessage = (RequestNewFriendActionLocalMessage) customResponsedMessage;
            long id = requestNewFriendActionLocalMessage.getId();
            String name = requestNewFriendActionLocalMessage.getName();
            String portrait = requestNewFriendActionLocalMessage.getPortrait();
            String content = requestNewFriendActionLocalMessage.getContent();
            com.baidu.tbadk.newFriends.a.a().a(id, content, requestNewFriendActionLocalMessage.getSt_type());
            com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
            kVar.a(id);
            kVar.a(name);
            kVar.a(0);
            kVar.b(portrait);
            kVar.c(content);
            kVar.b(0);
            com.baidu.tieba.im.e.a(new j(this, id, kVar), null);
        }
    }
}
