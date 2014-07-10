package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    public y() {
        super(2013002);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            SnapChatMsgHelper.a((GroupMsgData) customResponsedMessage);
        }
    }
}
