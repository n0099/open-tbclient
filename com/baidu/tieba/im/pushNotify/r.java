package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(q qVar, int i) {
        super(i);
        this.a = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case 202006:
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
