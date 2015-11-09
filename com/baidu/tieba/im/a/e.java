package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bDU = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean Wf;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        Wf = this.bDU.Wf();
        if (Wf && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bDF = this.bDU.Wa();
                bVar.bDG = this.bDU.Wc();
                str = this.bDU.bDM;
                if (str == null) {
                    this.bDU.bDM = bVar.emitTime;
                }
                str2 = this.bDU.bDN;
                if (str2 == null) {
                    this.bDU.bDN = bVar.emitTime;
                }
                str3 = this.bDU.bDN;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bDU.bDN = bVar.emitTime;
                }
                str4 = this.bDU.bDM;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bDU.bDM = bVar.emitTime;
                }
                list = this.bDU.bDK;
                list.add(bVar);
            }
        }
    }
}
