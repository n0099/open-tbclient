package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dco;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.dco = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean aqO;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        aqO = this.dco.aqO();
        if (aqO && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.netType = this.dco.aqJ();
                bVar.dca = this.dco.aqL();
                str = this.dco.dcg;
                if (str == null) {
                    this.dco.dcg = bVar.emitTime;
                }
                str2 = this.dco.dch;
                if (str2 == null) {
                    this.dco.dch = bVar.emitTime;
                }
                str3 = this.dco.dch;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dco.dch = bVar.emitTime;
                }
                str4 = this.dco.dcg;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dco.dcg = bVar.emitTime;
                }
                list = this.dco.dce;
                list.add(bVar);
            }
        }
    }
}
