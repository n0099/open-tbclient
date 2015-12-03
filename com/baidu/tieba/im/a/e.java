package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bTa = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean Zl;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        Zl = this.bTa.Zl();
        if (Zl && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bSL = this.bTa.Zg();
                bVar.bSM = this.bTa.Zi();
                str = this.bTa.bSS;
                if (str == null) {
                    this.bTa.bSS = bVar.emitTime;
                }
                str2 = this.bTa.bST;
                if (str2 == null) {
                    this.bTa.bST = bVar.emitTime;
                }
                str3 = this.bTa.bST;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.bTa.bST = bVar.emitTime;
                }
                str4 = this.bTa.bSS;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.bTa.bSS = bVar.emitTime;
                }
                list = this.bTa.bSQ;
                list.add(bVar);
            }
        }
    }
}
