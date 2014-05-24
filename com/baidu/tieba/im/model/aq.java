package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(MsglistModel msglistModel, int i) {
        super(i);
        this.a = msglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.adp.base.e eVar;
        if (customResponsedMessage.getCmd() == 2003113) {
            this.a.k();
        } else if (customResponsedMessage.getCmd() == 501126) {
            BdLog.d("simon", "onMessage", "msg = " + customResponsedMessage);
            if (customResponsedMessage instanceof ResponsedMessage) {
                this.a.s.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                eVar = this.a.mLoadDataCallBack;
                eVar.a(this.a.s);
            }
        }
    }
}
