package com.baidu.tieba.im.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.LiveChatRoomEventResponseMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo data;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (data = ((PushMessage) customResponsedMessage).getData()) != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveChatRoomEventResponseMessage(data.getContent()));
        }
    }
}
