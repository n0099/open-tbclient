package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    public t() {
        super(2013001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            com.baidu.tieba.im.pushNotify.a.i().a(q.a(groupMsgData), q.a, new u(this));
            com.baidu.tieba.im.chat.w.b().a(groupMsgData);
        }
    }
}
