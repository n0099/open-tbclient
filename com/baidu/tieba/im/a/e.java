package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c cmE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.cmE = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean agR;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        agR = this.cmE.agR();
        if (agR && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.cmp = this.cmE.agM();
                bVar.cmq = this.cmE.agO();
                str = this.cmE.cmw;
                if (str == null) {
                    this.cmE.cmw = bVar.emitTime;
                }
                str2 = this.cmE.cmx;
                if (str2 == null) {
                    this.cmE.cmx = bVar.emitTime;
                }
                str3 = this.cmE.cmx;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cmE.cmx = bVar.emitTime;
                }
                str4 = this.cmE.cmw;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cmE.cmw = bVar.emitTime;
                }
                list = this.cmE.cmu;
                list.add(bVar);
            }
        }
    }
}
