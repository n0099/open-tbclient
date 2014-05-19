package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ GroupMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(GroupMsglistModel groupMsglistModel, int i) {
        super(i);
        this.a = groupMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2015005) {
                this.a.a((ResponsedMessage<?>) customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2003146) {
                this.a.b(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2003149) {
                this.a.a(customResponsedMessage);
            }
        }
    }
}
