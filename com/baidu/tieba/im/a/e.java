package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.dnD = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean axa;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        axa = this.dnD.axa();
        if (axa && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.dno = this.dnD.awV();
                bVar.dnp = this.dnD.awX();
                str = this.dnD.dnv;
                if (str == null) {
                    this.dnD.dnv = bVar.emitTime;
                }
                str2 = this.dnD.dnw;
                if (str2 == null) {
                    this.dnD.dnw = bVar.emitTime;
                }
                str3 = this.dnD.dnw;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.dnD.dnw = bVar.emitTime;
                }
                str4 = this.dnD.dnv;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.dnD.dnv = bVar.emitTime;
                }
                list = this.dnD.dnt;
                list.add(bVar);
            }
        }
    }
}
