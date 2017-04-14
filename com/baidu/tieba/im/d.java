package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
import java.util.Iterator;
/* loaded from: classes.dex */
class d extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
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
