package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dhV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.dhV = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean avd;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        avd = this.dhV.avd();
        if (avd && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.dhG = this.dhV.auY();
                bVar.dhH = this.dhV.ava();
                str = this.dhV.dhN;
                if (str == null) {
                    this.dhV.dhN = bVar.emitTime;
                }
                str2 = this.dhV.dhO;
                if (str2 == null) {
                    this.dhV.dhO = bVar.emitTime;
                }
                str3 = this.dhV.dhO;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.dhV.dhO = bVar.emitTime;
                }
                str4 = this.dhV.dhN;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.dhV.dhN = bVar.emitTime;
                }
                list = this.dhV.dhL;
                list.add(bVar);
            }
        }
    }
}
