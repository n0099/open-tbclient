package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c cRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.cRT = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean ape;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        ape = this.cRT.ape();
        if (ape && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.cRE = this.cRT.aoZ();
                bVar.cRF = this.cRT.apb();
                str = this.cRT.cRL;
                if (str == null) {
                    this.cRT.cRL = bVar.emitTime;
                }
                str2 = this.cRT.cRM;
                if (str2 == null) {
                    this.cRT.cRM = bVar.emitTime;
                }
                str3 = this.cRT.cRM;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cRT.cRM = bVar.emitTime;
                }
                str4 = this.cRT.cRL;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cRT.cRL = bVar.emitTime;
                }
                list = this.cRT.cRJ;
                list.add(bVar);
            }
        }
    }
}
