package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dai;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.dai = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case 202006:
                    if (!(socketResponsedMessage instanceof PushNotifyMessage)) {
                        return;
                    }
                    this.dai.a((PushNotifyMessage) socketResponsedMessage);
                    return;
                default:
                    return;
            }
        }
    }
}
