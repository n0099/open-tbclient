package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ GroupMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(GroupMsglistModel groupMsglistModel, int i) {
        super(i);
        this.a = groupMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bt callback;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2013005) {
                this.a.a((ResponsedMessage<?>) customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001146) {
                this.a.b(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001149) {
                boolean a = this.a.a(customResponsedMessage);
                if ((customResponsedMessage.getOrginalMessage() instanceof LoadGroupHistoryMessage) && a && (callback = ((LoadGroupHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                    callback.f_();
                }
            }
        }
    }
}
