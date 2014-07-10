package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ PingManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PingManager pingManager, int i) {
        super(i);
        this.a = pingManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            return;
        }
        this.a.a(socketResponsedMessage);
    }
}
