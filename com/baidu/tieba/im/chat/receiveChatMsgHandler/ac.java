package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.bw;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    public ac() {
        super(2015006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                b.a((GroupMsgData) customResponsedMessage, false);
            } else {
                long[] a = ab.a().a(groupMsgData);
                if (a != null) {
                    ab.a().a(String.valueOf(a[0]), bw.c(a[1]));
                }
            }
            ab.a().b(groupMsgData);
        }
    }
}
