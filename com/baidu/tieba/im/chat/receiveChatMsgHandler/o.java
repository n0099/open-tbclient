package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    public o() {
        super(2015003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            BdLog.d("GET Personal Gid PULLMSG=" + groupMsgData.getGroupInfo().getGroupId());
            com.baidu.tieba.im.pushNotify.a.f().a(l.a(groupMsgData), l.a, new p(this));
            com.baidu.tieba.im.chat.x.b().a(groupMsgData);
        }
    }
}
