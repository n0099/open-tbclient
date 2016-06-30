package com.baidu.tieba.capture;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
/* loaded from: classes.dex */
class a extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 202006 && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() == 15) {
                new b(pushNotifyMessage).execute(new Void[0]);
            }
        }
    }
}
