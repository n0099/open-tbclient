package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c clG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.clG = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean agI;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        agI = this.clG.agI();
        if (agI && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.clq = this.clG.agD();
                bVar.clr = this.clG.agF();
                str = this.clG.cly;
                if (str == null) {
                    this.clG.cly = bVar.emitTime;
                }
                str2 = this.clG.clz;
                if (str2 == null) {
                    this.clG.clz = bVar.emitTime;
                }
                str3 = this.clG.clz;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.clG.clz = bVar.emitTime;
                }
                str4 = this.clG.cly;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.clG.cly = bVar.emitTime;
                }
                list = this.clG.clw;
                list.add(bVar);
            }
        }
    }
}
