package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes3.dex */
public class GroupMsglistAdapterStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001275) { // from class: com.baidu.tieba.im.chat.GroupMsglistAdapterStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.evZ != null && aVar.context != null) {
                        MsgActivityViewItemAdapter msgActivityViewItemAdapter = new MsgActivityViewItemAdapter(aVar.context, ChatMessage.TYPE_MSG_GROUP_ACTIVITY);
                        msgActivityViewItemAdapter.hh(true);
                        msgActivityViewItemAdapter.hg(true);
                        aVar.evZ.add(msgActivityViewItemAdapter);
                    }
                }
            }
        });
    }
}
