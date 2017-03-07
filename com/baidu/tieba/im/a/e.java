package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dca;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.dca = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean asa;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        asa = this.dca.asa();
        if (asa && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.netType = this.dca.arV();
                bVar.dbM = this.dca.arX();
                str = this.dca.dbS;
                if (str == null) {
                    this.dca.dbS = bVar.emitTime;
                }
                str2 = this.dca.dbT;
                if (str2 == null) {
                    this.dca.dbT = bVar.emitTime;
                }
                str3 = this.dca.dbT;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dca.dbT = bVar.emitTime;
                }
                str4 = this.dca.dbS;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dca.dbS = bVar.emitTime;
                }
                list = this.dca.dbQ;
                list.add(bVar);
            }
        }
    }
}
