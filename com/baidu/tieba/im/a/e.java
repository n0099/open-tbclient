package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bWI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bWI = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean aaq;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        aaq = this.bWI.aaq();
        if (aaq && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bWt = this.bWI.aal();
                bVar.bWu = this.bWI.aan();
                str = this.bWI.bWA;
                if (str == null) {
                    this.bWI.bWA = bVar.emitTime;
                }
                str2 = this.bWI.bWB;
                if (str2 == null) {
                    this.bWI.bWB = bVar.emitTime;
                }
                str3 = this.bWI.bWB;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.bWI.bWB = bVar.emitTime;
                }
                str4 = this.bWI.bWA;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.bWI.bWA = bVar.emitTime;
                }
                list = this.bWI.bWy;
                list.add(bVar);
            }
        }
    }
}
