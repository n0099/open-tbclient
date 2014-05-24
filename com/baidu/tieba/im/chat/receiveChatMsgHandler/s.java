package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    public s() {
        super(2015001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            com.baidu.tieba.im.pushNotify.a.f().a(q.a(groupMsgData), q.a, new t(this));
            com.baidu.tieba.im.chat.w.b().a(groupMsgData);
        }
    }
}
