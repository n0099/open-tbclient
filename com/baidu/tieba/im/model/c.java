package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ CommonGroupMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(CommonGroupMsglistModel commonGroupMsglistModel, int i) {
        super(i);
        this.a = commonGroupMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() != 103112) {
                if (socketResponsedMessage.getCmd() != 103102) {
                    return;
                }
                this.a.c(socketResponsedMessage);
                return;
            }
            this.a.b(socketResponsedMessage);
        }
    }
}
