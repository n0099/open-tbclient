package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c cZH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.cZH = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean asF;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        asF = this.cZH.asF();
        if (asF && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.netType = this.cZH.asA();
                bVar.cZt = this.cZH.asC();
                str = this.cZH.cZz;
                if (str == null) {
                    this.cZH.cZz = bVar.emitTime;
                }
                str2 = this.cZH.cZA;
                if (str2 == null) {
                    this.cZH.cZA = bVar.emitTime;
                }
                str3 = this.cZH.cZA;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.cZH.cZA = bVar.emitTime;
                }
                str4 = this.cZH.cZz;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.cZH.cZz = bVar.emitTime;
                }
                list = this.cZH.cZx;
                list.add(bVar);
            }
        }
    }
}
