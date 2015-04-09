package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bc)) {
            bc bcVar = (bc) customResponsedMessage.getData();
            if (bcVar.aXy != null && bcVar.context != null) {
                MsgActivityViewItemAdapter msgActivityViewItemAdapter = new MsgActivityViewItemAdapter(bcVar.context, ChatMessage.TYPE_MSG_GROUP_ACTIVITY);
                msgActivityViewItemAdapter.co(true);
                msgActivityViewItemAdapter.cn(true);
                bcVar.aXy.add(msgActivityViewItemAdapter);
            }
        }
    }
}
