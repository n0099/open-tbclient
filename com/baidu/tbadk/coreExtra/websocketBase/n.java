package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PingManager PQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PingManager pingManager, int i) {
        super(i);
        this.PQ = pingManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            return;
        }
        this.PQ.c(socketResponsedMessage);
    }
}
