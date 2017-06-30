package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dkm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.dkm = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean auz;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        auz = this.dkm.auz();
        if (auz && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.netType = this.dkm.auu();
                bVar.djY = this.dkm.auw();
                str = this.dkm.dke;
                if (str == null) {
                    this.dkm.dke = bVar.emitTime;
                }
                str2 = this.dkm.dkf;
                if (str2 == null) {
                    this.dkm.dkf = bVar.emitTime;
                }
                str3 = this.dkm.dkf;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dkm.dkf = bVar.emitTime;
                }
                str4 = this.dkm.dke;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dkm.dke = bVar.emitTime;
                }
                list = this.dkm.dkc;
                list.add(bVar);
            }
        }
    }
}
