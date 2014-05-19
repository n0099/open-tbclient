package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    public k() {
        super(2015004);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            b.a((GroupMsgData) customResponsedMessage, false);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfig.MSG_NEW));
        }
    }
}
