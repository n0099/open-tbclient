package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.dgy = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean auE;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        auE = this.dgy.auE();
        if (auE && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.dgj = this.dgy.auz();
                bVar.dgk = this.dgy.auB();
                str = this.dgy.dgq;
                if (str == null) {
                    this.dgy.dgq = bVar.emitTime;
                }
                str2 = this.dgy.dgr;
                if (str2 == null) {
                    this.dgy.dgr = bVar.emitTime;
                }
                str3 = this.dgy.dgr;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.dgy.dgr = bVar.emitTime;
                }
                str4 = this.dgy.dgq;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.dgy.dgq = bVar.emitTime;
                }
                list = this.dgy.dgo;
                list.add(bVar);
            }
        }
    }
}
