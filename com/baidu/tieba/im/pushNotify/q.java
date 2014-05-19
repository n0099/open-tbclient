package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.a = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            BdLog.d("cmd:" + socketResponsedMessage.getCmd());
            switch (socketResponsedMessage.getCmd()) {
                case MessageTypes.CMD_PUSH_NOTIFY /* 202006 */:
                    if (!(socketResponsedMessage instanceof PushNotifyMessage)) {
                        return;
                    }
                    this.a.a((PushNotifyMessage) socketResponsedMessage);
                    return;
                default:
                    return;
            }
        }
    }
}
