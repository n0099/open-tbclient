package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c cWQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.cWQ = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean apO;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        apO = this.cWQ.apO();
        if (apO && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.netType = this.cWQ.apJ();
                bVar.cWC = this.cWQ.apL();
                str = this.cWQ.cWI;
                if (str == null) {
                    this.cWQ.cWI = bVar.emitTime;
                }
                str2 = this.cWQ.cWJ;
                if (str2 == null) {
                    this.cWQ.cWJ = bVar.emitTime;
                }
                str3 = this.cWQ.cWJ;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.cWQ.cWJ = bVar.emitTime;
                }
                str4 = this.cWQ.cWI;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.cWQ.cWI = bVar.emitTime;
                }
                list = this.cWQ.cWG;
                list.add(bVar);
            }
        }
    }
}
