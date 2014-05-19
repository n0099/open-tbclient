package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, int i) {
        super(i);
        this.a = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            BdLog.e("msg == null");
        } else if (socketResponsedMessage.getCmd() != 205001) {
            if (socketResponsedMessage.getCmd() != 202001) {
                return;
            }
            this.a.a(socketResponsedMessage);
            this.a.b(socketResponsedMessage);
        } else {
            this.a.a(socketResponsedMessage);
            this.a.c(socketResponsedMessage);
        }
    }
}
