package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bAm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bAm = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean Vf;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        Vf = this.bAm.Vf();
        if (Vf && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bzX = this.bAm.Va();
                bVar.bzY = this.bAm.Vc();
                str = this.bAm.bAe;
                if (str == null) {
                    this.bAm.bAe = bVar.emitTime;
                }
                str2 = this.bAm.bAf;
                if (str2 == null) {
                    this.bAm.bAf = bVar.emitTime;
                }
                str3 = this.bAm.bAf;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bAm.bAf = bVar.emitTime;
                }
                str4 = this.bAm.bAe;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bAm.bAe = bVar.emitTime;
                }
                list = this.bAm.bAc;
                list.add(bVar);
            }
        }
    }
}
