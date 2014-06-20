package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.a.j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof PushNotifyMessageDecoder) {
            PushNotifyMessageDecoder pushNotifyMessageDecoder = (PushNotifyMessageDecoder) socketResponsedMessage;
            if (pushNotifyMessageDecoder.getMsgList() != null) {
                Iterator<PushNotifyMessage> it = pushNotifyMessageDecoder.getMsgList().iterator();
                while (it.hasNext()) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(it.next());
                }
            }
        }
        return socketResponsedMessage;
    }
}
