package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.framework.b.j {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.f' to match base method */
    @Override // com.baidu.adp.framework.b.g
    public final /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 instanceof PushNotifyMessageDecoder) {
            PushNotifyMessageDecoder pushNotifyMessageDecoder = (PushNotifyMessageDecoder) socketResponsedMessage2;
            if (pushNotifyMessageDecoder.d() != null) {
                Iterator<PushNotifyMessage> it = pushNotifyMessageDecoder.d().iterator();
                while (it.hasNext()) {
                    com.baidu.adp.framework.c.a().b(it.next());
                }
            }
        }
        return socketResponsedMessage2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(202006);
    }
}
