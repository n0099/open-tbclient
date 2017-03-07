package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PingManager aww;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PingManager pingManager, int i) {
        super(i);
        this.aww = pingManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            return;
        }
        this.aww.c(socketResponsedMessage);
    }
}
