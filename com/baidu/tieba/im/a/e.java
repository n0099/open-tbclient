package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c cUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.cUO = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean apQ;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        apQ = this.cUO.apQ();
        if (apQ && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.cUz = this.cUO.apL();
                bVar.cUA = this.cUO.apN();
                str = this.cUO.cUG;
                if (str == null) {
                    this.cUO.cUG = bVar.emitTime;
                }
                str2 = this.cUO.cUH;
                if (str2 == null) {
                    this.cUO.cUH = bVar.emitTime;
                }
                str3 = this.cUO.cUH;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cUO.cUH = bVar.emitTime;
                }
                str4 = this.cUO.cUG;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cUO.cUG = bVar.emitTime;
                }
                list = this.cUO.cUE;
                list.add(bVar);
            }
        }
    }
}
